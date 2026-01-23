package ddongman.algorithms.doit.graph.unionfind;

import java.util.HashSet;
import java.util.Set;

public class LieParty {

    public int solution(int N, int M, int[] truthInfo, int[][] parties) {
        UnionFind unionFind = new UnionFind(N);

        for (int[] party: parties) {
            int representative = party[0];

            for (int j = 1; j < party.length; j++) {
                unionFind.union(representative, party[j]);
            }
        }

        TruthChecker truthChecker = new TruthChecker(unionFind, truthInfo);
        int count = 0;
        for (int[] party: parties) {
            int representative = party[0];

            if (truthChecker.canLieInParty(representative)) {
                count++;
            }
        }

        return count;
    }

    static class UnionFind {
        private final int[] root;

        UnionFind(int size) {
            root = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                root[i] = i;
            }
        }

        private void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                root[rootB] = rootA;
            }
        }

        private int find(int a) {
            if (root[a] != a) {
                root[a] = find(root[a]);
            }
            return root[a];
        }
    }

    static class TruthChecker {
        private final UnionFind unionFind;
        private final Set<Integer> peopleWhoKnowTruth = new HashSet<>();

        TruthChecker(UnionFind unionFind, int[] truthInfo) {
            this.unionFind = unionFind;
            int peopleCnt = truthInfo[0];
            if (peopleCnt != 0) {
                for (int i = 1; i <= peopleCnt; i++) {
                    peopleWhoKnowTruth.add(unionFind.find(truthInfo[i]));
                }
            }
        }

        private boolean canLieInParty(int representative) {
            if (peopleWhoKnowTruth.isEmpty()) {
                return true;
            }

            return !peopleWhoKnowTruth.contains(unionFind.find(representative));
        }
    }
}

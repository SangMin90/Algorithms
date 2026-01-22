package ddongman.algorithms.doit.graph.unionfind;

import static ddongman.algorithms.doit.graph.unionfind.TravelPlan.YN.NO;
import static ddongman.algorithms.doit.graph.unionfind.TravelPlan.YN.YES;

public class TravelPlan {

    private int[] root;

    public YN solution(int N, int M, int[][] link, int[] plan) {
        init(N);
        connectCities(N, link);

        return isTravelPlanPossible(M, plan) ? YES: NO;
    }

    private void init(int N) {
        root = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            root[i] = i;
        }
    }

    private void connectCities(int N, int[][] link) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (link[i][j] == 1 && root[i + 1] != root[j + 1]) {
                    union(i + 1, j + 1);
                }
            }
        }
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) {
            return;
        }

        root[rootB] = rootA;
    }

    private int find(int a) {
        if (root[a] != a) {
            root[a] = find(root[a]);
        }
        return root[a];
    }

    private boolean isSameUnion(int a, int b) {
        return find(a) == find(b);
    }

    private boolean isTravelPlanPossible(int M, int[] plan) {
        for (int i = 0; i < M - 1; i++) {
            if (!isSameUnion(plan[i], plan[i + 1])) {
                return false;
            }
        }
        return true;
    }

    enum YN {
        YES, NO
    }
}

package ddongman.algorithms.doit.graph.unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static ddongman.algorithms.doit.graph.unionfind.UnionFind.SetUnion.FIND;
import static ddongman.algorithms.doit.graph.unionfind.UnionFind.SetUnion.UNION;
import static ddongman.algorithms.doit.graph.unionfind.UnionFind.YN.NO;
import static ddongman.algorithms.doit.graph.unionfind.UnionFind.YN.YES;

public class UnionFind {

    private int[] root;
    private List<YN> result = new ArrayList<>();

    public YN[] solution(int n, int m, int[][] operations) {
        init(n);

        for (int i = 0; i < m; i++) {
            int[] operation = operations[i];
            SetUnion setUnion = SetUnion.findByValue(operation[0]);
            int a = operation[1];
            int b = operation[2];

            if (UNION.equals(setUnion)) {
                union(a, b);
            } else if (FIND.equals(setUnion)) {
                result.add(isSameUnion(a, b));
            }
        }

        return result.toArray(YN[]::new);
    }

    public YN isSameUnion(int a, int b) {
        return root[a] == root[b] ? YES : NO;
    }

    public void union(int a, int b) {
        if (a == b) {
            return;
        }

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            root[rootA] = rootB;
        }
    }

    public int find(int element) {
        if (root[element] != element) {
            root[element] = find(root[element]);
        }

        return root[element];
    }

    private void init(int n) {
        root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
    }

    enum YN {
        YES, NO
    }

    enum SetUnion {
        UNION(0), FIND(1);

        private final int value;

        SetUnion(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static SetUnion findByValue(int value) {
            return Arrays.stream(values())
                    .filter(val -> val.getValue() == value)
                    .findFirst()
                    .orElseThrow(
                            () -> new NoSuchElementException(value + "값에 대응되는 집합 연산이 없습니다.")
                    );
        }
    }
}

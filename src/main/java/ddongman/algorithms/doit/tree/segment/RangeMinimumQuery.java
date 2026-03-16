package ddongman.algorithms.doit.tree.segment;

public class RangeMinimumQuery {

    private static final int MAX = 1_000_000_001;

    public int[] solution(int N, int M, int[] elements, int[][] queries) {
        SegmentTree segmentTree = new SegmentTree(N, elements);

        int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            result[i] = segmentTree.query(start, end);
        }

        return result;
    }

    static class SegmentTree {

        private final int[] tree;

        public SegmentTree(int N, int[] elements) {
            int length = size(N);
            tree = new int[length];

            for (int i = 0; i < length; i++) {
                tree[i] = MAX;
            }

            for (int i = 0; i < elements.length; i++) {
                int treeIndex = treeIndexFrom(i + 1);
                tree[treeIndex] = elements[i];
            }


            int start = 1;
            int end = tree.length - 1;
            while (end > start) {
                int parent = end / 2;
                tree[parent] = Math.min(tree[end - 1], tree[end]);

                end -= 2;
            }
        }

        private int query(int from, int to) {

            int start = treeIndexFrom(from);
            int end = treeIndexFrom(to);

            int min = MAX;

            while (start <= end) {
                if (start % 2 == 1) {
                    min = Math.min(min, tree[start]);
                }

                if (end % 2 == 0) {
                    min = Math.min(min, tree[end]);
                }

                start = (start + 1) / 2;
                end = (end - 1) / 2;
            }

            return min;
        }

        private int size(int N) {
            int base = 1;

            while (base < N) {
                base *= 2;
            }

            return base * 2;
        }

        private int treeIndexFrom(int index) {
            return index + tree.length / 2 - 1;
        }
    }
}


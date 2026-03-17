package ddongman.algorithms.doit.tree.segment;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class RangeMultiplyQuery {

    private static final int limit = 1_000_000_007;

    public long[] solution(int N, int M, int K, int[] elements, int[][] missions) {
        SegmentTree segmentTree = new SegmentTree(N, elements);

        long[] result = new long[K];

        int index = 0;
        for (int i = 0; i < M + K; i++) {
            MissionType type = MissionType.from(missions[i][0]);

            if (type.isUpdate()) {
                segmentTree.update(missions[i][1], missions[i][2]);
            }

            if (type.isQuery()) {
                result[index] = segmentTree.query(missions[i][1], missions[i][2]);
                index++;
            }
        }

        return result;
    }

    static class SegmentTree {

        private final long[] tree;

        public SegmentTree(int N, int[] elements) {

            int size = size(N);
            this.tree = new long[size];
            
            for (int i = 1; i < size; i++) {
                tree[i] = 1L;
            }

            for (int i = 0; i < N; i++) {
                int treeIndex = treeIndexFrom(i + 1);
                tree[treeIndex] = elements[i];
            }

            int start = 1;
            int end = size - 1;

            while (start < end) {
                int parent = end / 2;
                tree[parent] = ((tree[end - 1] % limit) * (tree[end] % limit)) % limit;

                end -= 2;
            }
        }

        private long query(int from, int to) {

            int start = treeIndexFrom(from);
            int end = treeIndexFrom(to);

            long result = 1L;

            while (start <= end) {
                if (start % 2 == 1) {
                    result = ((result % limit) * (tree[start] % limit)) % limit;
                }

                if (end % 2 == 0) {
                    result = ((result % limit) * (tree[end] % limit)) % limit;
                }

                start = (start + 1) / 2;
                end = (end - 1) / 2;
            }

            return result;
        }

        private void update(int index, int value) {

            int treeIndex = treeIndexFrom(index);
            tree[treeIndex] = value;

            while (treeIndex > 1) {
                int parentIndex = treeIndex / 2;
                tree[parentIndex] = (tree[parentIndex * 2] % limit) *
                        (tree[parentIndex * 2 + 1] % limit) % limit;
                treeIndex /= 2;
            }
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

    enum MissionType {

        UPDATE(1), QUERY(2),
        ;

        private final int type;

        MissionType(int type) {
            this.type = type;
        }

        public boolean isUpdate() {
            return UPDATE.equals(this);
        }

        public boolean isQuery() {
            return QUERY.equals(this);
        }

        public static MissionType from(int type) {
            return Arrays.stream(MissionType.values())
                    .filter(missionType -> missionType.type == type)
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        }
    }
}

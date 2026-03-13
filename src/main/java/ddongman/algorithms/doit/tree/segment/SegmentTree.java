package ddongman.algorithms.doit.tree.segment;

import static ddongman.algorithms.doit.tree.segment.SegmentTree.Mission.MissionType.*;

public class SegmentTree {

    private long[] tree;

    public long[] solution(long N, long M, long K, long[] elements, long[][] missions) {

        build(N, elements);

        long[] result = new long[(int) K];
        int resultIndex = 0;

        for (long[] m : missions) {

            Mission mission = new Mission(m[0], m[1], m[2]);

            if (mission.isUpdate()) {
                update((int) m[1], m[2]);
            }

            if (mission.isQuery()) {
                result[resultIndex] = query(m[1], m[2]);
                resultIndex++;
            }
        }

        return result;
    }

    private void build(long N, long[] elements) {

        int treeSize = size(N);
        tree = new long[treeSize];

        for (int i = 1; i <= treeSize - 1; i++) {

            tree[i] = 0L;
        }

        for (int i = 0; i < elements.length; i++) {

            int treeIndex = treeIndexFrom(i + 1);
            tree[treeIndex] = elements[i];
        }

        int start = 1;
        int end = tree.length - 1;
        while (end > start) {
            int parent = end / 2;
            tree[parent] = tree[end] + tree[end - 1];

            end -= 2;
        }
    }

    private int size(long N) {
        int base = 1;
        while (base < N) {
            base *= 2;
        }

        return base * 2;
    }

    private long query(long from, long to) {

        int start = treeIndexFrom(from);
        int end = treeIndexFrom(to);

        long sum = 0;

        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
            }

            if (end % 2 == 0) {
                sum += tree[end];
            }

            start = (start + 1) / 2;
            end = (end - 1) / 2;
        }

        return sum;
    }

    private int treeIndexFrom(long index) {

        return (int) index + tree.length / 2 - 1;
    }

    private void update(int index, long value) {

        int treeIndex = treeIndexFrom(index);
        tree[treeIndex] = value;

        while (treeIndex > 1) {

            treeIndex /= 2;
            tree[treeIndex] = tree[treeIndex * 2] + tree[treeIndex * 2 + 1];
        }
    }

    static class Mission {
        private final MissionType type;
        private final int a;
        private final int b;

        Mission(long type, long a, long b) {
            this.type = from((int) type);
            this.a = (int) a;
            this.b = (int) b;
        }

        public boolean isUpdate() {
            return UPDATE.equals(type);
        }

        public boolean isQuery() {
            return QUERY.equals(type);
        }

        enum MissionType {
            QUERY(0), UPDATE(1);

            private final int type;

            MissionType(int type) {
                this.type = type;
            }

            public static MissionType from(int type) {
                return values() [type % 2];
            }
        }
    }
}

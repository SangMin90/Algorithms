package ddongman.algorithms.doit.geometry;

public class LineSegmentGroupFinder {

    private final int N;
    private final LineSegment[] lines;
    private final UnionFind unionFind;

    public LineSegmentGroupFinder(LineSegment[] lines) {
        N = lines.length;
        this.lines = lines;
        unionFind = new UnionFind(N);
    }

    public GroupResult grouping() {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (lines[i].intersects(lines[j])) {
                    unionFind.union(i, j);
                }
            }
        }

        return new GroupResult(unionFind.getGroupCount(), unionFind.getMaxGroupSize());
    }

    static class LineSegment {

        private final Point p1;
        private final Point p2;

        protected LineSegment(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        protected int ccw(Point p) {
            Vector p1ToP = new Vector(p.x - p1.x, p.y - p1.y);
            Vector pToP2 = new Vector(p2.x - p.x, p2.y - p.y);

            long product = (long) p1ToP.x * pToP2.y - (long) pToP2.x * p1ToP.y;

            if (product > 0) {
                return 1;
            }

            if (product < 0) {
                return -1;
            }

            return 0;
        }

        protected boolean intersects(LineSegment other) {
            int ccw1 = this.ccw(other.p1);
            int ccw2 = this.ccw(other.p2);
            int ccw3 = other.ccw(this.p1);
            int ccw4 = other.ccw(this.p2);

            if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) {
                return true;
            }

            if ((ccw1 * ccw2 < 0 && ccw3 * ccw4 == 0) ||
                    (ccw1 * ccw2 == 0 && ccw3 * ccw4 < 0)) {
                return true;
            }

            if (ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0) {
                return isOverlapping(other);
            }

            return false;
        }

        private boolean isOverlapping(LineSegment other) {
            int minX1 = Math.min(this.p1.x, this.p2.x);
            int maxX1 = Math.max(this.p1.x, this.p2.x);
            int minY1 = Math.min(this.p1.y, this.p2.y);
            int maxY1 = Math.max(this.p1.y, this.p2.y);

            int minX2 = Math.min(other.p1.x, other.p2.x);
            int maxX2 = Math.max(other.p1.x, other.p2.x);
            int minY2 = Math.min(other.p1.y, other.p2.y);
            int maxY2 = Math.max(other.p1.y, other.p2.y);

            return maxX1 >= minX2 && maxX2 >= minX1 &&
                    maxY1 >= minY2 && maxY2 >= minY1;
        }

    }

    record Vector(
            int x,
            int y
    ) {}

    record Point(
            int x,
            int y
    ) {}

    static class UnionFind {

        private final int[] root;
        private final int[] size;
        private int groupCount;
        private int maxGroupSize;

        public UnionFind(int N) {
            root = new int[N];
            size = new int[N];

            for (int i = 0; i < N; i++) {
                root[i] = i;
                size[i] = 1;
            }

            groupCount = N;
            maxGroupSize = 1;
        }

        public void union(int a, int b) {

            if (a == b) {
                return;
            }

            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                root[rootA] = rootB;
                size[rootB] += size[rootA];
                maxGroupSize = Math.max(maxGroupSize, size[rootB]);

                groupCount--;
            }
        }

        public int find(int a) {

            if (root[a] != a) {
                root[a] = find(root[a]);
            }

            return root[a];
        }

        public int getGroupCount() {
            return groupCount;
        }

        public int getMaxGroupSize() {
            return maxGroupSize;
        }
    }

    record GroupResult(
            int groupCount,
            int maxGroupSize
    ) {}
}

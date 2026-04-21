package ddongman.algorithms.doit.geometry;

public class LineSegmentIntersectionChecker {

    public boolean isIntersect(LineSegment l1, LineSegment l2) {

        int ccw1 = l1.ccw(l2.p1);
        int ccw2 = l1.ccw(l2.p2);
        int ccw3 = l2.ccw(l1.p1);
        int ccw4 = l2.ccw(l1.p2);

        if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) {
            return true;
        }

        if ((ccw1 * ccw2 < 0 && ccw3 * ccw4 == 0) ||
                (ccw1 * ccw2 == 0 && ccw3 * ccw4 < 0)) {
            return true;
        }

        if (ccw1 * ccw2 == 0 && ccw3 * ccw4 == 0) {
            return l1.isParallelPointOnSegment(l2.p1) ||
                    l1.isParallelPointOnSegment(l2.p2) ||
                    l2.isParallelPointOnSegment(l1.p1) ||
                    l2.isParallelPointOnSegment(l1.p2);
        }

        return false;
    }

    static class LineSegment {

        private final Point p1;
        private final Point p2;

        public LineSegment(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public boolean isParallelPointOnSegment(Point p) {

            return ((p2.x - p.x) * (p1.x - p.x) <= 0 && (p2.y - p.y) * (p1.y - p.y) <= 0);
        }

        public int ccw(Point p) {

            Vector p1ToP = new Vector(p.x - p1.x, p.y - p1.y);
            Vector pToP2 = new Vector(p2.x - p.x, p2.y - p.y);

            long product = (long) p1ToP.x * pToP2.y - (long) p1ToP.y * pToP2.x;

            if (product > 0) {
                return 1;
            }

            if (product < 0) {
                return -1;
            }

            return 0;
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
}

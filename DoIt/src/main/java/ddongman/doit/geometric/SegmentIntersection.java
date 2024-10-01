package ddongman.doit.geometric;

public class SegmentIntersection {
    public int solution(int[][] a, int[][] b) {
        int gradientA = (a[1][1] - a[0][1]) / (a[1][0] - a[0][0]);
        int gradientB = (b[1][1] - b[0][1]) / (b[1][0] - b[0][0]);

        if (gradientA != gradientB) {
            int[] intersection = new int[]{
                    ((a[1][0] * a[0][1] - a[0][0] * a[1][1]) * (b[1][0] - b[0][0]) - (b[1][0] * b[0][1] - b[0][0] * b[1][1]) * (a[1][0] - a[0][0]))
                            / ((b[1][0] - b[0][0]) * (a[1][1] - a[0][1]) - (a[1][0] - a[0][0]) * (b[1][1] - b[0][1])),
                    ((b[1][0] * b[0][1] - b[0][0] * b[1][1]) * (b[1][1] - b[0][1]) - (a[1][0] * a[0][1] - a[0][0] * a[1][1]) * (a[1][1] - a[0][1]))
                            / ((b[1][0] - b[0][0]) * (a[1][1] - a[0][1]) - (a[1][0] - a[0][0]) * (b[1][1] - b[0][1]))
            };

            if (isPointOnLineSegment(intersection, a)
                    && ccw(a[0], intersection, a[1]) == 0) {
                return 1;
            }
        }

        if (isPointOnLineSegment(b[0], a)
            || isPointOnLineSegment(b[1], a)
            && ccw(a[0], b[1], a[1]) == 0) {
            return 1;
        }

        return 0;
    }

    private boolean isPointOnLineSegment(int[] targetPoint, int[][] segmentPoints) {
        return (targetPoint[0] - segmentPoints[0][0]) * (targetPoint[0] - segmentPoints[1][0]) <= 0
                && (targetPoint[1] - segmentPoints[0][1]) * (targetPoint[1] - segmentPoints[1][1]) <= 0;
    }

    private int ccw(int[] a, int[] b, int[] c) {
        int result = a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - (b[0] * a[1] + c[0] * b[1] + a[0] * c[1]);
        return Integer.compare(result, 0);
    }
}

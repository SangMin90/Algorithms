package ddongman.algorithms.doit.geometric;

public class AreaOfPolygonCalculator {

    public double calculateArea(Point[] points) {

        long area = 0;

        for (int i = 0; i < points.length - 1; i++) {
            area += points[i].x * points[i + 1].y -
                    points[i + 1].x * points[i].y;
        }

        area += points[points.length - 1].x * points[0].y -
                points[0].x * points[points.length - 1].y;

        return Math.abs(area) / 2.0;
    }

    record Point(
            long x,
            long y
    ) {}
}

package ddongman.algorithms.doit.geometry;

public class CCW {

    public Direction findDirection(Point p1, Point p2, Point p3) {

        Vector p12 = new Vector(p2.x - p1.x, p2.y - p1.y);
        Vector p23 = new Vector(p3.x - p2.x, p3.y - p2.y);

        int product = p12.x * p23.y - p12.y * p23.x;
        if (product > 0) {
            return Direction.CLOCKWISE;
        }

        if (product < 0) {
            return Direction.COUNTER_CLOCKWISE;
        }

        return Direction.STRAIGHT;
    }

    record Vector(
            int x,
            int y
    ) {}

    record Point(
            int x,
            int y
    ) {}

    enum Direction {
        CLOCKWISE, COUNTER_CLOCKWISE, STRAIGHT
    }
}

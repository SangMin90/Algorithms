package ddongman.algorithms.doit.geometry;

import ddongman.algorithms.doit.geometry.CCW.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static ddongman.algorithms.doit.geometry.CCW.*;
import static org.assertj.core.api.Assertions.assertThat;

class CCWTest {

    private CCW sut;

    @Test
    void case1() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(5, 5);
        Point p3 = new Point(7, 3);

        sut = new CCW();

        Direction result = sut.findDirection(p1, p2, p3);

        assertThat(result).isEqualByComparingTo(Direction.COUNTER_CLOCKWISE);
    }

    @Test
    void case2() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(5, 5);

        sut = new CCW();

        Direction result = sut.findDirection(p1, p2, p3);

        assertThat(result).isEqualByComparingTo(Direction.STRAIGHT);
    }

    @Test
    void case3() {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(7, 3);
        Point p3 = new Point(5, 5);

        sut = new CCW();

        Direction result = sut.findDirection(p1, p2, p3);

        assertThat(result).isEqualByComparingTo(Direction.CLOCKWISE);
    }
}
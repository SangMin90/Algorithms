package ddongman.algorithms.doit.geometric;

import org.junit.jupiter.api.Test;

import static ddongman.algorithms.doit.geometric.AreaOfPolygonCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;

class AreaOfPolygonCalculatorTest {

    private AreaOfPolygonCalculator sut = new AreaOfPolygonCalculator();

    @Test
    void case1() {
        int N = 4;
        Point[] points = new Point[]{
                new Point(0, 0),
                new Point(0, 10),
                new Point(10, 10),
                new Point(10, 0),
        };

        double result = sut.calculateArea(points);

        assertThat(result).isEqualTo(100.0);
    }

    @Test
    void case2() {
        int N = 3;
        Point[] points = new Point[]{
                new Point(-146, 4),
                new Point(69, -60),
                new Point(17, 159),
        };

        double result = sut.calculateArea(points);

        assertThat(result).isEqualTo(21878.5);
    }

    @Test
    void case3() {
        int N = 3;
        Point[] points = new Point[]{
                new Point(-146, 4),
                new Point(69, -60),
                new Point(17, 159),
        };

        double result = sut.calculateArea(points);

        assertThat(result).isEqualTo(21878.5);
    }

    @Test
    void case4() {
        int N = 4;
        Point[] points = new Point[]{
                new Point(0, 0),
                new Point(2, 1),
                new Point(0, 2),
                new Point(-2, 1),
                new Point(1, 1),
        };

        double result = sut.calculateArea(points);

        assertThat(result).isEqualTo(2.5);
    }

    @Test
    void case5() {
        int N = 3;
        Point[] points = new Point[]{
                new Point(117,74),
                new Point(-229,47),
                new Point(-32,-238),
        };

        double result = sut.calculateArea(points);

        assertThat(result).isEqualTo(51964.5);
    }

    @Test
    void case6() {
        int N = 4;
        Point[] points = new Point[]{
                new Point(-100000, -100000),
                new Point(100000, -100000),
                new Point(100000, 100000),
                new Point(-100000, 100000),
        };

        double result = sut.calculateArea(points);

        assertThat(result).isEqualTo(40000000000.0);

    }
}
package ddongman.algorithms.doit.geometry;

import ddongman.algorithms.doit.geometry.LineSegmentIntersectionChecker.LineSegment;
import ddongman.algorithms.doit.geometry.LineSegmentIntersectionChecker.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineSegmentIntersectionCheckerTest {

    private LineSegmentIntersectionChecker sut;

    @BeforeEach
    void setUp() {
        sut = new LineSegmentIntersectionChecker();
    }

    @Test
    void case1() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(1, 5), new Point(5, 1));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isTrue();
    }

    @Test
    void case2() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(6, 10), new Point(10, 6));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isFalse();
    }

    @Test
    void case3() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(5, 5), new Point(1, 1));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isTrue();
    }

    @Test
    void case4() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(3, 3), new Point(5, 5));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isTrue();
    }

    @Test
    void case5() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(3, 3), new Point(1, 3));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isTrue();
    }

    @Test
    void case6() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(5, 5), new Point(9, 9));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isTrue();
    }

    @Test
    void case7() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(6, 6), new Point(9, 9));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isFalse();
    }

    @Test
    void case8() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(5, 5), new Point(1, 5));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isTrue();
    }

    @Test
    void case9() {

        LineSegment l1 = new LineSegment(new Point(1, 1), new Point(5, 5));
        LineSegment l2 = new LineSegment(new Point(6, 6), new Point(1, 5));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isFalse();
    }

    @Test
    void case10() {

        LineSegment l1 = new LineSegment(new Point(-585138, 624449), new Point(597569, 642747));
        LineSegment l2 = new LineSegment(new Point(834204, 697090), new Point(70156, 425183));

        boolean intersect = sut.isIntersect(l1, l2);

        assertThat(intersect).isFalse();
    }
}
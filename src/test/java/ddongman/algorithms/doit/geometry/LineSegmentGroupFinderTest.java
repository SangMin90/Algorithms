package ddongman.algorithms.doit.geometry;

import ddongman.algorithms.doit.geometry.LineSegmentGroupFinder.GroupResult;
import ddongman.algorithms.doit.geometry.LineSegmentGroupFinder.LineSegment;
import ddongman.algorithms.doit.geometry.LineSegmentGroupFinder.Point;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

class LineSegmentGroupFinderTest {

    private LineSegmentGroupFinder sut;

    @Test
    void case1() {
        LineSegment[] lines = new LineSegment[]{
                new LineSegment(new Point(1, 1), new Point(2, 3)),
                new LineSegment(new Point(2, 1), new Point(0, 0)),
                new LineSegment(new Point(1, 0), new Point(1, 1)),
        };
        sut = new LineSegmentGroupFinder(lines);

        GroupResult result = sut.grouping();

        SoftAssertions.assertSoftly(
                softly -> {
                    softly.assertThat(result.groupCount()).isEqualTo(1);
                    softly.assertThat(result.maxGroupSize()).isEqualTo(3);
                }
        );
    }

    @Test
    void case2() {
        LineSegment[] lines = new LineSegment[]{
                new LineSegment(new Point(-1, -1), new Point(1, 1)),
                new LineSegment(new Point(-2, -2), new Point(2, 2)),
                new LineSegment(new Point(0, 1), new Point(-1, 0)),
        };
        sut = new LineSegmentGroupFinder(lines);

        GroupResult result = sut.grouping();

        SoftAssertions.assertSoftly(
                softly -> {
                    softly.assertThat(result.groupCount()).isEqualTo(2);
                    softly.assertThat(result.maxGroupSize()).isEqualTo(2);
                }
        );
    }

    @Test
    void case3() {
        LineSegment[] lines = new LineSegment[]{
                new LineSegment(new Point(-1, -1), new Point(1, 1)),
        };
        sut = new LineSegmentGroupFinder(lines);

        GroupResult result = sut.grouping();

        SoftAssertions.assertSoftly(
                softly -> {
                    softly.assertThat(result.groupCount()).isEqualTo(1);
                    softly.assertThat(result.maxGroupSize()).isEqualTo(1);
                }
        );
    }

    @Test
    void case4() {
        LineSegment[] lines = new LineSegment[]{
                new LineSegment(new Point(35, 19), new Point(7, -22)),
                new LineSegment(new Point(-38, -45), new Point(42, 44)),
                new LineSegment(new Point(33, 30), new Point(-44, -14)),
                new LineSegment(new Point(-19, 22), new Point(20, -4))
        };

        sut = new LineSegmentGroupFinder(lines);

        GroupResult result = sut.grouping();

        SoftAssertions.assertSoftly(
                softly -> {
                    softly.assertThat(result.groupCount()).isEqualTo(1);
                    softly.assertThat(result.maxGroupSize()).isEqualTo(4);
                }
        );
    }
}
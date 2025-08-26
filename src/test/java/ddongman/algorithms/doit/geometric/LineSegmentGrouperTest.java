package ddongman.algorithms.doit.geometric;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineSegmentGrouperTest {

    private LineSegmentGrouper sut;

    @BeforeEach
    void setUp() {
        sut = new LineSegmentGrouper();
    }

    @Test
    void case1() {
        int n = 3;
        int[][] segments = new int[n][];
        segments[0] = new int[]{1, 1, 2, 3};
        segments[1] = new int[]{2, 1, 0, 0};
        segments[2] = new int[]{1, 0, 1, 1};

        int[] result = sut.solution(n, segments);

        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(3);
    }

    @Test
    void case2() {
        int n = 3;
        int[][] segments = new int[n][];
        segments[0] = new int[]{-1, -1, 1, 1};
        segments[1] = new int[]{-2, -2, 2, 2};
        segments[2] = new int[]{0, 1, -1, 0};

        int[] result = sut.solution(n, segments);

        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(2);
    }
}
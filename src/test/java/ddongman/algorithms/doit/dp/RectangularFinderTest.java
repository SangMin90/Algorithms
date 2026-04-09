package ddongman.algorithms.doit.dp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangularFinderTest {

    private RectangularFinder sut;

    @Test
    void case1() {
        int N = 4;
        int M = 4;
        int[][] points = new int[][]{
                {0, 1, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 0, 1, 0},
        };
        sut = new RectangularFinder(N, M, points);

        int result = sut.maxArea();

        Assertions.assertThat(result).isEqualTo(4);
    }

}
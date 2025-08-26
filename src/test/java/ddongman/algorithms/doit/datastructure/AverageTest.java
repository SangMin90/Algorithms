package ddongman.algorithms.doit.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AverageTest {

    private Average sut;
    private Double epsilon = 0.01;

    @BeforeEach
    void setUp() {
        sut = new Average();
    }

    @Test
    void case1() {
        int n = 3;
        int[] scores = new int[]{40, 80, 60};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 75.0)).isTrue();
    }

    @Test
    void case2() {
        int n = 3;
        int[] scores = new int[]{10, 20, 30};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 66.666667)).isTrue();
    }

    @Test
    void case3() {
        int n = 4;
        int[] scores = new int[]{1, 100, 100, 100};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 75.25)).isTrue();
    }

    @Test
    void case4() {
        int n = 5;
        int[] scores = new int[]{1, 2, 4, 8, 16};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 38.75)).isTrue();
    }

    @Test
    void case5() {
        int n = 2;
        int[] scores = new int[]{3, 10};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 65.0)).isTrue();
    }

    @Test
    void case6() {
        int n = 4;
        int[] scores = new int[]{10, 20, 0, 100};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 32.5)).isTrue();
    }

    @Test
    void case7() {
        int n = 1;
        int[] scores = new int[]{50};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 100.0)).isTrue();
    }

    @Test
    void case8() {
        int n = 9;
        int[] scores = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90};

        double result = sut.solution(n, scores);

        assertThat(betweenAbsoluteOrRelativeError(result, 55.55555555555556)).isTrue();
    }

    private boolean betweenAbsoluteOrRelativeError(double actual, double expected) {
        return Math.abs(actual - expected) < epsilon || (Math.abs(actual - expected)) / expected < epsilon;
    }
}
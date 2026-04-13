package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixMultiplicationTest {

    private MatrixMultiplication sut;

    @Test
    void case1() {
        int N = 3;
        int[][] size = new int[][]{
                {5, 3},
                {3, 2},
                {2, 6},
        };
        sut = new MatrixMultiplication(size);

        int result = sut.min(0, N - 1);

        assertThat(result).isEqualTo(90);
    }

    @Test
    void case2() {
        int N = 1;
        int[][] size = new int[][]{
                {1, 3},
        };
        sut = new MatrixMultiplication(size);

        int result = sut.min(0, N - 1);

        assertThat(result).isEqualTo(0);
    }
}
package ddongman.algorithms.leet.matrix;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotatorTest {

    private Rotator sut;

    @BeforeEach
    void setUp() {
        sut = new Rotator();
    }

    @Test
    void case1() {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

//        sut.rotate(matrix);
        sut.rotate2(matrix);

        assertThat(matrix).isEqualTo(new int[][]{
            {13, 9, 5, 1},
            {14, 10, 6, 2},
            {15, 11, 7, 3},
            {16, 12, 8, 4}
        });
    }

    @Test
    void case2() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

//        sut.rotate(matrix);
        sut.rotate2(matrix);

        assertThat(matrix).isEqualTo(new int[][]{
            {7,4,1},{8,5,2},{9,6,3}
        });
    }

    @Test
    void case3() {
        int[][] matrix = {{1}};

//        sut.rotate(matrix);
        sut.rotate2(matrix);

        assertThat(matrix).isEqualTo(new int[][]{{1}});
    }
}
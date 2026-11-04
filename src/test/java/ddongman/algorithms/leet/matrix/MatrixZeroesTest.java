package ddongman.algorithms.leet.matrix;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MatrixZeroesTest {

    private MatrixZeroes sut;

    @Test
    void case1() {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        sut = new MatrixZeroes();

//        int[][] result = sut.setZeroes(matrix);
        int[][] result = sut.setZeroesV2(matrix);

        assertThat(result).isEqualTo(
            new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}
        );
    }

    @Test
    void case2() {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        sut = new MatrixZeroes();

//        int[][] result = sut.setZeroes(matrix);
        int[][] result = sut.setZeroesV2(matrix);

        assertThat(result).isEqualTo(
            new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}}
        );
    }
    
    @Test
    void case3() {
        int[][] matrix = {{1, 0}};
        sut = new MatrixZeroes();

//        int[][] result = sut.setZeroes(matrix);
        int[][] result = sut.setZeroesV2(matrix);

        assertThat(result).isEqualTo(
            new int[][]{{0, 0}}
        );
    }
}
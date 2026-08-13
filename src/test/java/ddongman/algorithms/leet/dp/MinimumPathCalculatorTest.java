package ddongman.algorithms.leet.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumPathCalculatorTest {

    private MinimumPathCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumPathCalculator();
    }

    @Test
    void case1() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

//        int result = sut.minPathSum(grid);
//        int result = sut.minPathSum2(grid);
        int result = sut.minPathSum3(grid);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void case2() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};

//        int result = sut.minPathSum(grid);
//        int result = sut.minPathSum2(grid);
        int result = sut.minPathSum3(grid);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void case3() {
        int[][] grid = {{100, 100, 100, 100}};

//        int result = sut.minPathSum(grid);
//        int result = sut.minPathSum2(grid);
        int result = sut.minPathSum3(grid);

        assertThat(result).isEqualTo(400);
    }
}
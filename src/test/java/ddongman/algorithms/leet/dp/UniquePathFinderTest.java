package ddongman.algorithms.leet.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UniquePathFinderTest {

    private UniquePathFinder sut;

    @Test
    void case1() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        sut = new UniquePathFinder();

        int result = sut.uniquePathsWithObstacles(obstacleGrid);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[][] obstacleGrid = {{0,1},{0,0}};
        sut = new UniquePathFinder();

        int result = sut.uniquePathsWithObstacles(obstacleGrid);

        assertThat(result).isEqualTo(1);
    }
}
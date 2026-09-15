package ddongman.algorithms.leet.contest.weekly519;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CycleShifterTest {

    private CycleShifter sut;

    @Test
    void case1() {
        int n = 2;
        int[][] grid = {{1,2},{3,4}};
        int[] rowShift = {1,0};
        int[] colShift = {0,1};
        sut = new CycleShifter();

        int[][] result = sut.cyclicShift(n, grid, rowShift, colShift);

        assertThat(result).isEqualTo(new int[][]{
            {2,4},{3,1}
        });
    }

    @Test
    void case2() {
        int n = 3;
        int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
        int[] rowShift = {1,2,0};
        int[] colShift = {2,2,1};
        sut = new CycleShifter();

        int[][] result = sut.cyclicShift(n, grid, rowShift, colShift);

        assertThat(result).isEqualTo(new int[][]{
            {7,8,5},{2,3,9},{6,4,1}
        });
    }
}
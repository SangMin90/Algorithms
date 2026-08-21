package ddongman.algorithms.leet.intervals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerIntervalHandlerTest {

    private IntegerIntervalHandler sut;

    @BeforeEach
    public void setUp() {
        sut = new IntegerIntervalHandler();
    }

    @Test
    void case1() {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};

        int[][] result = sut.insert(intervals, newInterval);

        assertThat(result).isEqualTo(new int[][]{{1,5},{6,9}});
    }

    @Test
    void case2() {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};

//        int[][] result = sut.insert(intervals, newInterval);
        int[][] result = sut.insert2(intervals, newInterval);

        assertThat(result).isEqualTo(new int[][]{{1,2},{3,10},{12,16}});
    }

    @Test
    void case3() {
        int[][] intervals = {{2, 3}, {6, 9}};
        int[] newInterval = {1, 5};

//        int[][] result = sut.insert(intervals, newInterval);
        int[][] result = sut.insert2(intervals, newInterval);

        assertThat(result).isEqualTo(new int[][]{{1,5},{6,9}});
    }

    @Test
    void case4() {
        int[][] intervals = {{3, 4}, {6, 9}};
        int[] newInterval = {1, 2};

//        int[][] result = sut.insert(intervals, newInterval);
        int[][] result = sut.insert2(intervals, newInterval);

        assertThat(result).isEqualTo(new int[][]{{1, 2}, {3, 4}, {6, 9}});
    }

    @Test
    void case5() {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};

        int[][] result = sut.insert(intervals, newInterval);

        assertThat(result).isEqualTo(new int[][]{{1, 5}});
    }
}
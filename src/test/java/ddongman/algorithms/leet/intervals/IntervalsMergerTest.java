package ddongman.algorithms.leet.intervals;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntervalsMergerTest {

    private IntervalsMerger sut;

    @BeforeEach
    void setUp() {
        sut = new IntervalsMerger();
    }

    @Test
    void case1() {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

//        int[][] result = sut.merge(intervals);
//        int[][] result = sut.merge2(intervals);
        int[][] result = sut.merge3(intervals);

        assertThat(result).isEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});
    }

    @Test
    void case2() {
        int[][] intervals = {{1, 4}, {4, 5}};

//        int[][] result = sut.merge(intervals);
//        int[][] result = sut.merge2(intervals);
        int[][] result = sut.merge3(intervals);

        assertThat(result).isEqualTo(new int[][]{{1, 5}});
    }

    @Test
    void case3() {
        int[][] intervals = {{4, 7}, {1, 4}};

//        int[][] result = sut.merge(intervals);
//        int[][] result = sut.merge2(intervals);
        int[][] result = sut.merge3(intervals);

        assertThat(result).isEqualTo(new int[][]{{1, 7}});
    }

    @Test
    void case4() {
        int[][] intervals = {{1, 4}, {0, 0}};

//        int[][] result = sut.merge(intervals);
//        int[][] result = sut.merge2(intervals);
        int[][] result = sut.merge3(intervals);

        assertThat(result).isEqualTo(new int[][]{{0, 0}, {1, 4}});
    }
}
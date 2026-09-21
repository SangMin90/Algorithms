package ddongman.algorithms.leet.contest.weekly520;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IntersectingPairsCounterTest {

    private IntersectingPairsCounter sut;

    @Test
    void case1() {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}};
        sut = new IntersectingPairsCounter();

        int result = sut.countIntersectingIntervals(intervals);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[][] intervals = {{1, 5}, {2, 4}, {3, 6}};
        sut = new IntersectingPairsCounter();

        int result = sut.countIntersectingIntervals(intervals);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
        sut = new IntersectingPairsCounter();

        int result = sut.countIntersectingIntervals(intervals);

        assertThat(result).isEqualTo(0);
    }

}
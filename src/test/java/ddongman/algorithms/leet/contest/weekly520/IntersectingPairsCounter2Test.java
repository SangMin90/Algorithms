package ddongman.algorithms.leet.contest.weekly520;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IntersectingPairsCounter2Test {

    private IntersectingPairsCounter2 sut;

    @Test
    void case1() {
        int[][] intervals = {{1,2},{2,3},{3,4}};
        sut = new IntersectingPairsCounter2();

//        long result = sut.countIntersectingIntervals(intervals);
        long result = sut.countIntersectingIntervals2(intervals);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[][] intervals = {{1,5},{2,4},{3,6}};
        sut = new IntersectingPairsCounter2();

//        long result = sut.countIntersectingIntervals(intervals);
        long result = sut.countIntersectingIntervals2(intervals);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        int[][] intervals = {{1,2},{3,4},{5,6}};
        sut = new IntersectingPairsCounter2();

//        long result = sut.countIntersectingIntervals(intervals);
        long result = sut.countIntersectingIntervals2(intervals);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int[][] intervals = {{72,79},{72,98},{49,92},{69,79}};
        sut = new IntersectingPairsCounter2();

//        long result = sut.countIntersectingIntervals(intervals);
        long result = sut.countIntersectingIntervals2(intervals);

        assertThat(result).isEqualTo(6);
    }
}
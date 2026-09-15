package ddongman.algorithms.leet.contest.weekly519;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ShadowPairCounterTest {

    private ShadowPairCounter sut;

    @Test
    void case1() {
        int[] nums = {3, 1, 4, 1, 5};
        sut = new ShadowPairCounter();

        long result = sut.shadowPairs(nums);

        assertThat(result).isEqualTo(3L);
    }

    @Test
    void case2() {
        int[] nums = {6,7,6,6,7};
        sut = new ShadowPairCounter();

        long result = sut.shadowPairs(nums);

        assertThat(result).isEqualTo(4L);
    }

    @Test
    void case3() {
        int[] nums = {1,2,3,4};
        sut = new ShadowPairCounter();

        long result = sut.shadowPairs(nums);

        assertThat(result).isEqualTo(6L);
    }
}
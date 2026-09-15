package ddongman.algorithms.leet.contest.weekly519;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ShadowPairCounter2Test {

    private ShadowPairCounter2 sut;

    @Test
    void case1() {
        int[] nums = {3,1,4,2,5};
        sut = new ShadowPairCounter2();

        int result = sut.shadowPairs(nums);

        assertThat(result).isEqualTo(5);
    }
}
package ddongman.algorithms.leet.slidingWindow;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumSubarraySumFinderTest {

    private MinimumSubarraySumFinder sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumSubarraySumFinder();
    }

    @Test
    void case1() {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};

        int result = sut.minSubArrayLen(target, nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int target = 4;
        int[] nums = {1,4,4};

        int result = sut.minSubArrayLen(target, nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int target = 11;
        int[] nums = {1,1,1,1,1,1,1,1};

        int result = sut.minSubArrayLen(target, nums);

        assertThat(result).isEqualTo(0);
    }
}
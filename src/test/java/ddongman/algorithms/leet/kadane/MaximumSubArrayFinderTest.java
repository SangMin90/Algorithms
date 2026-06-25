package ddongman.algorithms.leet.kadane;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumSubArrayFinderTest {

    private MaximumSubArrayFinder sut;

    @BeforeEach
    void setUp() {
        sut = new MaximumSubArrayFinder();
    }

    @Test
    void case1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

//        int result = sut.maxSubArray(nums);
        int result = sut.maxSubArray2(nums);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case2() {
        int[] nums = {1};

//        int result = sut.maxSubArray(nums);
        int result = sut.maxSubArray2(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int[] nums = {5,4,-1,7,8};

//        int result = sut.maxSubArray(nums);
        int result = sut.maxSubArray2(nums);

        assertThat(result).isEqualTo(23);
    }

    @Test
    void case4() {
        int[] nums = {-2, -1};

//        int result = sut.maxSubArray(nums);
        int result = sut.maxSubArray2(nums);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void case5() {
        int[] nums = {1, -1, -2};

//        int result = sut.maxSubArray(nums);
        int result = sut.maxSubArray2(nums);

        assertThat(result).isEqualTo(1);
    }
}
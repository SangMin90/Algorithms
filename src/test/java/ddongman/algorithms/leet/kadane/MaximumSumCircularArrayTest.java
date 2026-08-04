package ddongman.algorithms.leet.kadane;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumSumCircularArrayTest {

    private MaximumSumCircularArray sut;

    @BeforeEach
    void setUp() {
        sut = new MaximumSumCircularArray();
    }

    @Test
    void case1() {
        int[] nums = {1, -2, 3, -2};

        int result = sut.maxSubarraySumCircular(nums);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int[] nums = {5, -3, 5};

        int result = sut.maxSubarraySumCircular(nums);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void case3() {
        int[] nums = {-3, -2, -3};

        int result = sut.maxSubarraySumCircular(nums);

        assertThat(result).isEqualTo(-2);
    }

    @Test
    void case4() {
        int[] nums = {1, 1, 1, 1, 100, -1, 1, -99, 10, 10, 10};

        int result = sut.maxSubarraySumCircular(nums);

        assertThat(result).isEqualTo(134);
    }
}
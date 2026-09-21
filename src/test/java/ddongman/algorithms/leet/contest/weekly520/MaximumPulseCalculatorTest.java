package ddongman.algorithms.leet.contest.weekly520;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MaximumPulseCalculatorTest {

    private MaximumPulseCalculator sut;

    @Test
    void case1() {
        int[] nums = {1, 5, 2};
        sut = new MaximumPulseCalculator();

        long result = sut.maxValue(nums);

        assertThat(result).isEqualTo(6L);
    }

    @Test
    void case2() {
        int[] nums = {6, 4, 3};
        sut = new MaximumPulseCalculator();

        long result = sut.maxValue(nums);

        assertThat(result).isEqualTo(7L);
    }

    @Test
    void case3() {
        int[] nums = {9, 7};
        sut = new MaximumPulseCalculator();

        long result = sut.maxValue(nums);

        assertThat(result).isEqualTo(2L);
    }
}
package ddongman.algorithms.leet.contest.weekly517;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SubsetSumCalculatorTest {

    private SubsetSumCalculator sut;

    @Test
    void case1() {
        int[] nums = {5, 6, 10};
        int sum = 4;
        sut = new SubsetSumCalculator();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int[] nums = {10,2};
        int sum = 13;
        sut = new SubsetSumCalculator();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        int[] nums = {6,3};
        int sum = 8;
        sut = new SubsetSumCalculator();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(-1);
    }
}
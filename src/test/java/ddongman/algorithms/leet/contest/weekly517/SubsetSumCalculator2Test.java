package ddongman.algorithms.leet.contest.weekly517;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SubsetSumCalculator2Test {

    private SubsetSumCalculator2 sut;

    @Test
    void case1() {
        int[] nums = {10,2};
        int sum = 13;
        sut = new SubsetSumCalculator2();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int[] nums = {6, 3};
        int sum = 8;
        sut = new SubsetSumCalculator2();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int[] nums = {2, 2};
        int sum = 7;
        sut = new SubsetSumCalculator2();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void case4() {
        int[] nums = {8, 12};
        int sum = 10;
        sut = new SubsetSumCalculator2();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case5() {
        int[] nums = {9, 3};
        int sum = 13;
        sut = new SubsetSumCalculator2();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case6() {
        int[] nums = {6, 11};
        int sum = 10;
        sut = new SubsetSumCalculator2();

        int result = sut.minOperations(nums, sum);

        assertThat(result).isEqualTo(2);
    }
}
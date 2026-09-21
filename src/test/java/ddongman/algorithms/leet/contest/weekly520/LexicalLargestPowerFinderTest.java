package ddongman.algorithms.leet.contest.weekly520;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LexicalLargestPowerFinderTest {

    private LexicalLargestPowerFinder sut;

    @Test
    void case1() {
        int[] nums = {7, 5};
        sut = new LexicalLargestPowerFinder();

//        int[] result = sut.largestPower(nums);
        int[] result = sut.largestPower2(nums);

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 2});
    }

    @Test
    void case2() {
        int[] nums = {3, 1, 7};
        sut = new LexicalLargestPowerFinder();

        int[] result = sut.largestPower(nums);

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3});
    }

    @Test
    void case3() {
        int[] nums = {1, 3, 2, 5};
        sut = new LexicalLargestPowerFinder();

        int[] result = sut.largestPower(nums);

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3});
    }

    @Test
    void case4() {
        int[] nums = {5, 4, 1, 3};
        sut = new LexicalLargestPowerFinder();

        int[] result = sut.largestPower(nums);

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 1});
    }

    @Test
    void case5() {
        int[] nums = {8, 7};
        sut = new LexicalLargestPowerFinder();

        int[] result = sut.largestPower(nums);

        assertThat(result).isEqualTo(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0});
    }
}
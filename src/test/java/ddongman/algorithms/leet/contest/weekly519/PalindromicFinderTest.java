package ddongman.algorithms.leet.contest.weekly519;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PalindromicFinderTest {

    private PalindromicFinder sut;

    @Test
    void case1() {
        int[] nums = {10,12,14,16};
        sut = new PalindromicFinder();

        long result = sut.minOperations(nums);

        assertThat(result).isEqualTo(9L);
    }

    @Test
    void case2() {
        int[] nums = {9,10,11,10};
        sut = new PalindromicFinder();

        long result = sut.minOperations(nums);

        assertThat(result).isEqualTo(2L);
    }

    @Test
    void case3() {
        int[] nums = {125};
        sut = new PalindromicFinder();

        long result = sut.minOperations(nums);

        assertThat(result).isEqualTo(2L);
    }

    @Test
    void case4() {
        int[] nums = {1000000000};
        sut = new PalindromicFinder();

        long result = sut.minOperations(nums);

        assertThat(result).isEqualTo(50000001L);
    }

    @Test
    void case5() {
        int[] nums = {999999998};
        sut = new PalindromicFinder();

        long result = sut.minOperations(nums);

        assertThat(result).isEqualTo(50000000L);
    }
}
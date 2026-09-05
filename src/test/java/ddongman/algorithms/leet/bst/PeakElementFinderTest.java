package ddongman.algorithms.leet.bst;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PeakElementFinderTest {

    private PeakElementFinder sut;

    @Test
    void case1() {
        int[] nums = {1, 2, 3, 1};
        sut = new PeakElementFinder();

//        int result = sut.findPeakElement(nums);
        int result = sut.findPeakElement2(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        sut = new PeakElementFinder();

//        int result = sut.findPeakElement(nums);
        int result = sut.findPeakElement2(nums);

        assertThat(result).isIn(5, 1);
    }

    @Test
    void case3() {
        int[] nums = {2, 1};
        sut = new PeakElementFinder();

//        int result = sut.findPeakElement(nums);
        int result = sut.findPeakElement2(nums);

        assertThat(result).isEqualTo(0);
    }
}
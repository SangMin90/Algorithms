package ddongman.algorithms.leet.twopointer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortedArrayMergerTest {

    private SortedArrayMerger sut;

    @BeforeEach
    void setUp() {
        sut = new SortedArrayMerger();
    }

    @Test
    void case1() {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;

        int[] result = sut.merge(nums1, m, nums2, n);

        assertThat(result).isEqualTo(new int[]{1,2,2,3,5,6});
    }

    @Test
    void case2() {
        int[] nums1 = {1};
        int m = 1;
        int[] nums2 = {};
        int n = 0;

        int[] result = sut.merge(nums1, m, nums2, n);

        assertThat(result).isEqualTo(new int[]{1});
    }

    @Test
    void case3() {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;

        int[] result = sut.merge(nums1, m, nums2, n);

        assertThat(result).isEqualTo(new int[]{1});
    }
}
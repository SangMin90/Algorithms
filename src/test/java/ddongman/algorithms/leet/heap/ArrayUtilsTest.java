package ddongman.algorithms.leet.heap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayUtilsTest {

    private ArrayUtils sut = new ArrayUtils();

    @Test
    void case1() {
        int[] nums = {3, 2, 1, 5, 6, 4};

//        int result = sut.findKthLargest(nums, 2);
//        int result = sut.findKthLargest2(nums, 2);
        int result = sut.findKthLargest3(nums, 2);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case2() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};

//        int result = sut.findKthLargest(nums, 4);
//        int result = sut.findKthLargest2(nums, 4);
        int result = sut.findKthLargest3(nums, 4);

        assertThat(result).isEqualTo(4);
    }
}
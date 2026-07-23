package ddongman.algorithms.leet.bst;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InsertPositionFinderTest {

    private InsertPositionFinder sut = new InsertPositionFinder();

    @Test
    void case1() {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        int result = sut.searchInsert(nums, target);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        int result = sut.searchInsert(nums, target);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int[] nums = {1, 3, 5, 6};
        int target = 7;

        int result = sut.searchInsert(nums, target);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case4() {
        int[] nums = {1, 3};
        int target = 0;

        int result = sut.searchInsert(nums, target);

        assertThat(result).isEqualTo(0);
    }
}
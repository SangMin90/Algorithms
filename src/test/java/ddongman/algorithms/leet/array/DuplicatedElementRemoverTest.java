package ddongman.algorithms.leet.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DuplicatedElementRemoverTest {

    private DuplicatedElementRemover sut;

    @Test
    void case1() {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        sut = new DuplicatedElementRemover();

//        int result = sut.removeDuplicates(nums);
//        int result = sut.removeDuplicates2(nums);
        int result = sut.removeDuplicates3(nums);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void case2() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        sut = new DuplicatedElementRemover();

//        int result = sut.removeDuplicates(nums);
//        int result = sut.removeDuplicates2(nums);
        int result = sut.removeDuplicates3(nums);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case3() {
        int[] nums = {-1000};
        sut = new DuplicatedElementRemover();

//        int result = sut.removeDuplicates(nums);
//        int result = sut.removeDuplicates2(nums);
        int result = sut.removeDuplicates3(nums);

        assertThat(result).isEqualTo(1);
    }
}
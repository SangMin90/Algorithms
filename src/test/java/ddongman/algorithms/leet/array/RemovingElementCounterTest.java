package ddongman.algorithms.leet.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemovingElementCounterTest {

    private RemovingElementCounter sut;

    @BeforeEach
    void setUp() {
        sut = new RemovingElementCounter();
    }

    @Test
    void case1() {
        int[] nums = {3,2,2,3};
        int val = 3;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case3() {
        int[] nums = {};
        int val = 0;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int[] nums = {2};
        int val = 3;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case5() {
        int[] nums = {3, 3};
        int val = 3;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case6() {
        int[] nums = {3, 3};
        int val = 5;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case7() {
        int[] nums = {4, 5};
        int val = 5;

//        int result = sut.removeElement(nums, val);
//        int result = sut.removeElement2(nums, val);
        int result = sut.removeElement3(nums, val);

        assertThat(result).isEqualTo(1);
    }
}
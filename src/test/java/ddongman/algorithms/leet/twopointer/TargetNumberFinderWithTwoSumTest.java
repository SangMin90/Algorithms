package ddongman.algorithms.leet.twopointer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TargetNumberFinderWithTwoSumTest {

    private TargetNumberFinderWithTwoSum sut;

    @BeforeEach
    void setUp() {
        sut = new TargetNumberFinderWithTwoSum();
    }

    @Test
    void case1() {
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] result = sut.twoSum(numbers, target);

        assertThat(result).isEqualTo(new int[]{1, 2});
    }

    @Test
    void case2() {
        int[] numbers = {2,3,4};
        int target = 6;

        int[] result = sut.twoSum(numbers, target);

        assertThat(result).isEqualTo(new int[]{1, 3});
    }

    @Test
    void case3() {
        int[] numbers = {-1,0};
        int target = -1;

        int[] result = sut.twoSum(numbers, target);

        assertThat(result).isEqualTo(new int[]{1, 2});
    }
}
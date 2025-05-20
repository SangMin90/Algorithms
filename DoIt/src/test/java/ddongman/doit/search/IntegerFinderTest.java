package ddongman.doit.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class IntegerFinderTest {

    private IntegerFinder sut;

    @BeforeEach
    void setUp() {
        sut = new IntegerFinder();
    }

    @Test
    void case1() {
        int n = 5;
        int[] nums = new int[]{4, 1, 5, 2, 3};
        int k = 5;
        int[] targetNums = new int[]{1, 3, 7, 9, 5};

        int[] result = sut.solution(n, nums, k, targetNums);

        Assertions.assertThat(result).isEqualTo(new int[]{1, 1, 0, 0, 1});
    }
}
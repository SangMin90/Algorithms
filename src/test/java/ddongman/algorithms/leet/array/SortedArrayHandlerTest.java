package ddongman.algorithms.leet.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedArrayHandlerTest {

    private SortedArrayHandler sut;

    @BeforeEach
    void setUp() {
        sut = new SortedArrayHandler();
    }

    @Test
    void case1() {
        int[] nums = {1, 1, 2};

        int result = sut.removeDuplicates(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int result = sut.removeDuplicates(nums);

        assertThat(result).isEqualTo(5);
    }
}
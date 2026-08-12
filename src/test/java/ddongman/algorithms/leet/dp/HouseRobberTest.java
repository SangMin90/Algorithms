package ddongman.algorithms.leet.dp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HouseRobberTest {

    private HouseRobber sut;

    @BeforeEach
    void setUp() {
        sut = new HouseRobber();
    }

    @Test
    void case1() {
        int[] nums = {1, 2, 3, 1};

        int result = sut.rob(nums);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        int[] nums = {2, 7, 9, 3, 1};

        int result = sut.rob(nums);

        assertThat(result).isEqualTo(12);
    }

    @Test
    void case3() {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        int result = sut.rob(nums);

        assertThat(result).isEqualTo(0);
    }
}
package ddongman.algorithms.leet.math;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigIntegerCalculatorTest {

    private BigIntegerCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new BigIntegerCalculator();
    }

    @Test
    void case1() {
        int[] digits = {1, 2, 3};

//        int[] result = sut.plusOne(digits);
        int[] result = sut.plusOne2(digits);

        assertThat(result).isEqualTo(new int[]{1, 2, 4});
    }

    @Test
    void case2() {
        int[] digits = {4, 3, 2, 1};

//        int[] result = sut.plusOne(digits);
        int[] result = sut.plusOne2(digits);

        assertThat(result).isEqualTo(new int[]{4, 3, 2, 2});
    }

    @Test
    void case3() {
        int[] digits = {9};

//        int[] result = sut.plusOne(digits);
        int[] result = sut.plusOne2(digits);

        assertThat(result).isEqualTo(new int[]{1, 0});
    }
}
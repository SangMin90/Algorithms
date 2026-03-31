package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OneMakerTest {

    private static OneMaker sut;

    @BeforeAll
    static void setUp() {
        sut = new OneMaker(1_000_000);
    }

    @Test
    void case1() {
        int N = 2;

        int result = sut.countMakingOneOf(N);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        int N = 10;

        int result = sut.countMakingOneOf(N);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        int N = 7;

        int result = sut.countMakingOneOf(N);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case4() {
        int N = 642;

        int result = sut.countMakingOneOf(N);

        assertThat(result).isEqualTo(10);
    }
}
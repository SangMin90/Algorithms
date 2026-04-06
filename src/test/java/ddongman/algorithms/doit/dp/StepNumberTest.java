package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StepNumberTest {

    private static StepNumber sut;

    @BeforeAll
    static void setUp() {
        sut = new StepNumber(100);
    }

    @Test
    void case1() {
        int N = 1;

        long result = sut.countOf(N);

        assertThat(result).isEqualTo(9L);
    }

    @Test
    void case2() {
        int N = 2;

        long result = sut.countOf(N);

        assertThat(result).isEqualTo(17L);
    }

    @Test
    void case3() {
        int N = 3;

        long result = sut.countOf(N);

        assertThat(result).isEqualTo(32L);
    }

    @Test
    void case4() {
        int N = 30;

        long result = sut.countOf(N);

        assertThat(result).isEqualTo(365808847);
    }
}
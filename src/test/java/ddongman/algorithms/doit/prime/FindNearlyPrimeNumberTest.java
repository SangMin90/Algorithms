package ddongman.algorithms.doit.prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindNearlyPrimeNumberTest {
    private FindNearlyPrimeNumber sut;

    @BeforeEach
    void setUp() {
        sut = new FindNearlyPrimeNumber();
    }

    @Test
    void case1() {
        long a = 1;
        long b = 1000;

        long result = sut.solution(a, b);

        assertThat(result).isEqualTo(25L);
    }

    @Test
    void case2() {
        long a = 1;
        long b = 10;

        long result = sut.solution(a, b);

        assertThat(result).isEqualTo(3L);
    }

    @Test
    void case3() {
        long a = 5324;
        long b = 894739;

        long result = sut.solution(a, b);

        assertThat(result).isEqualTo(183L);
    }
}
package ddongman.algorithms.doit.prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class FinderSquareFreeIntegerTest {

    private FinderSquareFreeInteger sut;

    @BeforeEach
    void setUp() {
        sut = new FinderSquareFreeInteger();
    }

    @Test
    void case1() {
        long n = 1;
        long m = 10;

        long result = sut.solution(n, m);

        assertThat(result).isEqualTo(7L);
    }

    @Test
    void case2() {
        long n = 15;
        long m = 15;

        long result = sut.solution(n, m);

        assertThat(result).isEqualTo(1L);
    }

    @Test
    void case3() {
        long n = 1;
        long m = 1000;

        long result = sut.solution(n, m);

        assertThat(result).isEqualTo(608L);
    }
}
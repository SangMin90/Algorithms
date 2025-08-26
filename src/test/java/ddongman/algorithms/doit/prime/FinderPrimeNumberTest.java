package ddongman.algorithms.doit.prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinderPrimeNumberTest {

    private FinderPrimeNumber sut;

    @BeforeEach
    void setUp() {
        sut = new FinderPrimeNumber();
    }

    @Test
    void case1() {
        int m = 3;
        int n = 16;

        int[] result = sut.solution(m, n);

        assertThat(result).isEqualTo(new int[]{3, 5, 7, 11, 13});
    }

    @Test
    void case2() {
        int m = 3;
        int n = 16;

        int[] result = sut.solution2(m, n);

        assertThat(result).isEqualTo(new int[]{3, 5, 7, 11, 13});
    }
}
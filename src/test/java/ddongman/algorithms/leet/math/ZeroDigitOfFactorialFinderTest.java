package ddongman.algorithms.leet.math;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ZeroDigitOfFactorialFinderTest {

    private ZeroDigitOfFactorialFinder sut;

    @Test
    void case1() {
        int n = 3;
        sut = new ZeroDigitOfFactorialFinder();

        int result = sut.trailingZeroes(n);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case2() {
        int n = 5;
        sut = new ZeroDigitOfFactorialFinder();

        int result = sut.trailingZeroes(n);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int n = 0;
        sut = new ZeroDigitOfFactorialFinder();

        int result = sut.trailingZeroes(n);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int n = 10000;
        sut = new ZeroDigitOfFactorialFinder();

        int result = sut.trailingZeroes(n);

        assertThat(result).isEqualTo(2499);
    }
}
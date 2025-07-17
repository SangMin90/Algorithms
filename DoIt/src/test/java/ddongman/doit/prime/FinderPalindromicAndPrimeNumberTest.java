package ddongman.doit.prime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinderPalindromicAndPrimeNumberTest {
    private FinderPalindromicAndPrimeNumber sut;

    @BeforeEach
    void setUp() {
        sut = new FinderPalindromicAndPrimeNumber();
    }

    @Test
    void case1() {
        int n = 31;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(101);
    }

    @Test
    void case2() {
        int n = 1;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int n = 2;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case4() {
        int n = 10;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(11);
    }

    @Test
    void case5() {
        int n = 102;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(131);
    }
}
package ddongman.algorithms.leet.twopointer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PalindromeValidatorTest {

    private PalindromeValidator sut;

    @BeforeEach
    void setUp() {
        sut = new PalindromeValidator();
    }

    @Test
    void case1() {
        String s = "A man, a plan, a canal: Panama";

        boolean result = sut.isPalindrome(s);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        String s = "race a car";

        boolean result = sut.isPalindrome(s);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        String s = " ";

        boolean result = sut.isPalindrome(s);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        String s = "  ";

        boolean result = sut.isPalindrome(s);

        assertThat(result).isTrue();
    }

    @Test
    void case5() {
        String s = "  a";

        boolean result = sut.isPalindrome(s);

        assertThat(result).isTrue();
    }

    @Test
    void case6() {
        String s = "0P";

        boolean result = sut.isPalindrome(s);

        assertThat(result).isFalse();
    }
}
package ddongman.algorithms.leet.math;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PalindromeNumberTest {

    private PalindromeNumber sut;

    @BeforeEach
    void setUp() {
        sut = new PalindromeNumber();
    }

    @Test
    void case1() {
        int x = 121;

//        boolean result = sut.isPalindrome(x);
//        boolean result = sut.isPalindrome2(x);
        boolean result = sut.isPalindrome3(x);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        int x = 1;

//        boolean result = sut.isPalindrome(x);
//        boolean result = sut.isPalindrome2(x);
        boolean result = sut.isPalindrome3(x);

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        int x = -121;

//        boolean result = sut.isPalindrome(x);
//        boolean result = sut.isPalindrome2(x);
        boolean result = sut.isPalindrome3(x);

        assertThat(result).isFalse();
    }

    @Test
    void case4() {
        int x = 10;

//        boolean result = sut.isPalindrome(x);
        boolean result = sut.isPalindrome2(x);

        assertThat(result).isFalse();
    }

    @Test
    void case5() {
        int x = 1001;

//        boolean result = sut.isPalindrome(x);
        boolean result = sut.isPalindrome2(x);

        assertThat(result).isTrue();
    }
}
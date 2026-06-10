package ddongman.algorithms.leet.stack;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParenthesesValidatorTest {

    private ParenthesesValidator sut;

    @BeforeEach
    void setUp() {
        sut = new ParenthesesValidator();
    }

    @Test
    void case1() {
        String s = "()";

        boolean result = sut.isValid5(s);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        String s = "()[]{}";

//        boolean result = sut.isValid(s);
//        boolean result = sut.isValid2(s);
//        boolean result = sut.isValid3(s);
//        boolean result = sut.isValid4(s);
        boolean result = sut.isValid5(s);

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        String s = "(]";

//        boolean result = sut.isValid(s);
//        boolean result = sut.isValid2(s);
//        boolean result = sut.isValid3(s);
//        boolean result = sut.isValid4(s);
        boolean result = sut.isValid5(s);

        assertThat(result).isFalse();
    }

    @Test
    void case4() {
        String s = "([])";

//        boolean result = sut.isValid(s);
//        boolean result = sut.isValid2(s);
//        boolean result = sut.isValid3(s);
//        boolean result = sut.isValid4(s);
        boolean result = sut.isValid5(s);

        assertThat(result).isTrue();
    }

    @Test
    void case5() {
        String s = "([)]";

//        boolean result = sut.isValid(s);
//        boolean result = sut.isValid2(s);
//        boolean result = sut.isValid3(s);
//        boolean result = sut.isValid4(s);
        boolean result = sut.isValid5(s);

        assertThat(result).isFalse();
    }

    @Test
    void case6() {
        String s = "(])";

//        boolean result = sut.isValid(s);
//        boolean result = sut.isValid2(s);
//        boolean result = sut.isValid3(s);
//        boolean result = sut.isValid4(s);
        boolean result = sut.isValid5(s);

        assertThat(result).isFalse();
    }

    @Test
    void case7() {
        String s = "){";

//        boolean result = sut.isValid(s);
//        boolean result = sut.isValid2(s);
//        boolean result = sut.isValid3(s);
//        boolean result = sut.isValid4(s);
        boolean result = sut.isValid5(s);

        assertThat(result).isFalse();
    }
}
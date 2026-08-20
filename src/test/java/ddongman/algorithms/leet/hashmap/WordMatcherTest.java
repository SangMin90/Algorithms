package ddongman.algorithms.leet.hashmap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordMatcherTest {

    private WordMatcher sut;

    @BeforeEach
    public void setUp() {
        sut = new WordMatcher();
    }

    @Test
    void case1() {
        String pattern = "abba";
        String s = "dog cat cat dog";

        boolean result = sut.wordPattern(pattern, s);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        String pattern = "abba";
        String s = "dog cat cat fish";

        boolean result = sut.wordPattern(pattern, s);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        String pattern = "aaaa";
        String s = "dog cat cat dog";

        boolean result = sut.wordPattern(pattern, s);

        assertThat(result).isFalse();
    }

    @Test
    void case4() {
        String pattern = "abba";
        String s = "dog dog dog dog";

        boolean result = sut.wordPattern(pattern, s);

        assertThat(result).isFalse();
    }

    @Test
    void case5() {
        String pattern = "aaa";
        String s = "aa aa aa aa";

        boolean result = sut.wordPattern(pattern, s);

        assertThat(result).isFalse();
    }
}
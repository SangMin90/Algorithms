package ddongman.algorithms.leet.hashmap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AnagramValidatorTest {

    private AnagramValidator sut;

    @Test
    void case1() {
        String s = "anagram";
        String t = "nagaram";
        sut = new AnagramValidator();

        boolean result = sut.isAnagram(s, t);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        String s = "rat";
        String t = "car";
        sut = new AnagramValidator();

        boolean result = sut.isAnagram(s, t);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        String s = "ab";
        String t = "a";
        sut = new AnagramValidator();

        boolean result = sut.isAnagram(s, t);

        assertThat(result).isFalse();
    }
}
package ddongman.algorithms.leet.hashmap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RansomNoteTest {

    private RansomNote sut;

    @BeforeEach
    void setUp() {
        sut = new RansomNote();
    }

    @Test
    void case1() {
        String ransomNote = "a";
        String magazine = "b";

        boolean result = sut.canConstruct(ransomNote, magazine);

        assertThat(result).isFalse();
    }

    @Test
    void case2() {
        String ransomNote = "aa";
        String magazine = "ab";

        boolean result = sut.canConstruct(ransomNote, magazine);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = sut.canConstruct(ransomNote, magazine);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        String ransomNote = "a";
        String magazine = "b";

        boolean result = sut.canConstructMoreFast(ransomNote, magazine);

        assertThat(result).isFalse();
    }

    @Test
    void case5() {
        String ransomNote = "aa";
        String magazine = "ab";

        boolean result = sut.canConstructMoreFast(ransomNote, magazine);

        assertThat(result).isFalse();
    }

    @Test
    void case6() {
        String ransomNote = "aa";
        String magazine = "aab";

        boolean result = sut.canConstructMoreFast(ransomNote, magazine);

        assertThat(result).isTrue();
    }
}
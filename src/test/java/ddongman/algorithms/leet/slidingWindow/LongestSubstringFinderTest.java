package ddongman.algorithms.leet.slidingWindow;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestSubstringFinderTest {

    private LongestSubstringFinder sut;

    @BeforeEach
    void setUp() {
        sut = new LongestSubstringFinder();
    }

    @Test
    void case1() {
        String s = "abcabcbb";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        String s = "bbbbb";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        String s = "pwwkew";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case4() {
        String s = " ";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case5() {
        String s = "au";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case6() {
        String s = "abca";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case7() {
        String s = "dvdf";

//        int result = sut.lengthOfLongestSubstring(s);
//        int result = sut.lengthOfLongestSubstring2(s);
        int result = sut.lengthOfLongestSubstring3(s);

        assertThat(result).isEqualTo(3);
    }
}
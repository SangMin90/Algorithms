package ddongman.algorithms.leet.slidingWindow;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubstringWithConcatenatedWordsFinderTest {

    private SubstringWithConcatenatedWordsFinder sut;

    @BeforeEach
    void setUp() {
        sut = new SubstringWithConcatenatedWordsFinder();
    }

    @Test
    void case1() {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};

//        List<Integer> result = sut.findSubstring(s, words);
//        List<Integer> result = sut.findSubstring2(s, words);
//        List<Integer> result = sut.findSubstring3(s, words);
//        List<Integer> result = sut.findSubstring4(s, words);
        List<Integer> result = sut.findSubstring5(s, words);

        assertThat(result).containsExactlyInAnyOrder(0, 9);
    }

    @Test
    void case2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","word"};

//        List<Integer> result = sut.findSubstring(s, words);
//        List<Integer> result = sut.findSubstring2(s, words);
//        List<Integer> result = sut.findSubstring3(s, words);
        List<Integer> result = sut.findSubstring4(s, words);

        assertThat(result).isEmpty();
    }

    @Test
    void case3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};

//        List<Integer> result = sut.findSubstring(s, words);
//        List<Integer> result = sut.findSubstring2(s, words);
//        List<Integer> result = sut.findSubstring3(s, words);
        List<Integer> result = sut.findSubstring4(s, words);
//
        assertThat(result).containsExactlyInAnyOrder(6, 9, 12);
    }

    @Test
    void case4() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

//        List<Integer> result = sut.findSubstring(s, words);
//        List<Integer> result = sut.findSubstring2(s, words);
//        List<Integer> result = sut.findSubstring3(s, words);
//        List<Integer> result = sut.findSubstring4(s, words);
        List<Integer> result = sut.findSubstring5(s, words);

        assertThat(result).containsExactlyInAnyOrder(8);
    }

    @Test
    void case5() {
        String s = "a";
        String[] words = {"a","a"};

//        List<Integer> result = sut.findSubstring(s, words);
//        List<Integer> result = sut.findSubstring2(s, words);
//        List<Integer> result = sut.findSubstring3(s, words);
        List<Integer> result = sut.findSubstring4(s, words);

        assertThat(result).isEmpty();
    }

    @Test
    void case6() {
        String s = "aaaaaaaaaaaaaa";
        String[] words = {"aa","aa"};

//        List<Integer> result = sut.findSubstring(s, words);
//        List<Integer> result = sut.findSubstring2(s, words);
//        List<Integer> result = sut.findSubstring3(s, words);
//        List<Integer> result = sut.findSubstring4(s, words);
        List<Integer> result = sut.findSubstring5(s, words);

        assertThat(result).containsExactlyInAnyOrder(0,1,2,3,4,5,6,7,8,9,10);
    }
}
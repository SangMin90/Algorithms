package ddongman.algorithms.leet.trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordDictionaryTest {

    private WordDictionary sut;

    @BeforeEach
    void setUp() {
        sut = new WordDictionary();
    }

    @Test
    void case1() {
//        sut.addWord("bad");
//        sut.addWord("dad");
//        sut.addWord("mad");
        sut.addWord2("bad");
        sut.addWord2("dad");
        sut.addWord2("mad");

//        boolean result1 = sut.search("pad");
//        boolean result2 = sut.search("bad");
//        boolean result3 = sut.search(".ad");
//        boolean result4 = sut.search("b..");
        boolean result1 = sut.search2("pad");
        boolean result2 = sut.search2("bad");
        boolean result3 = sut.search2(".ad");
        boolean result4 = sut.search2("b..");

        assertThat(result1).isFalse();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
        assertThat(result4).isTrue();
    }

    @Test
    void case2() {
//        sut.addWord("a");
//        sut.addWord("a");
        sut.addWord2("a");
        sut.addWord2("a");

//        boolean result1 = sut.search(".");
//        boolean result2 = sut.search("a");
//        boolean result3 = sut.search("aa");
//        boolean result4 = sut.search("a");
//        boolean result5 = sut.search(".a");
//        boolean result6 = sut.search("a.");
        boolean result1 = sut.search2(".");
        boolean result2 = sut.search2("a");
        boolean result3 = sut.search2("aa");
        boolean result4 = sut.search2("a");
        boolean result5 = sut.search2(".a");
        boolean result6 = sut.search2("a.");

        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isFalse();
        assertThat(result4).isTrue();
        assertThat(result5).isFalse();
        assertThat(result6).isFalse();
    }

    @Test
    void case3() {
//        sut.addWord("a");
//        sut.addWord("ab");
        sut.addWord2("a");
        sut.addWord2("ab");

//        boolean result1 = sut.search("a");
//        boolean result2 = sut.search("a.");
//        boolean result3 = sut.search("ab");
//        boolean result4 = sut.search(".a");
//        boolean result5 = sut.search(".b");
//        boolean result6 = sut.search("ab.");
//        boolean result7 = sut.search(".");
//        boolean result8 = sut.search("..");
        boolean result1 = sut.search2("a");
        boolean result2 = sut.search2("a.");
        boolean result3 = sut.search2("ab");
        boolean result4 = sut.search2(".a");
        boolean result5 = sut.search2(".b");
        boolean result6 = sut.search2("ab.");
        boolean result7 = sut.search2(".");
        boolean result8 = sut.search2("..");

        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
        assertThat(result4).isFalse();
        assertThat(result5).isTrue();
        assertThat(result6).isFalse();
        assertThat(result7).isTrue();
        assertThat(result8).isTrue();
    }
}
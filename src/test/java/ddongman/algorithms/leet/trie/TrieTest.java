package ddongman.algorithms.leet.trie;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrieTest {

    private Trie sut;

    @BeforeEach
    void setUp() {
        sut = new Trie();
    }

    @Test
    void case1() {
//        sut.insert("apple");
        sut.insert2("apple");

//        boolean result = sut.search("apple");
        boolean result = sut.search2("apple");

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
//        sut.insert("apple");
        sut.insert2("apple");

//        boolean result = sut.search("app");
        boolean result = sut.search2("app");

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
//        sut.insert("apple");
        sut.insert2("apple");

//        boolean result = sut.startsWith("app");
        boolean result = sut.startsWith2("app");

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
//        sut.insert("apple");
//        sut.insert("app");
        sut.insert2("apple");
        sut.insert2("app");

//        boolean result = sut.search("app");
        boolean result = sut.search2("app");

        assertThat(result).isTrue();
    }
}
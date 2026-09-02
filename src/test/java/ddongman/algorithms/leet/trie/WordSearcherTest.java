package ddongman.algorithms.leet.trie;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WordSearcherTest {

    private WordSearcher sut;

    @Test
    void case1() {
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("eat","oath");
    }

    @Test
    void case2() {
        char[][] board = {{'a', 'b'}, {'c', 'd'}};
        String[] words = {"abcb"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).isEmpty();
    }

    @Test
    void case3() {
        char[][] board = {{'a'}};
        String[] words = {"a"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("a");
    }

    @Test
    void case4() {
        char[][] board = {{'a', 'a'}};
        String[] words = {"a"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("a");
    }

    @Test
    void case5() {
        char[][] board = {{'a', 'b'}};
        String[] words = {"ab"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("ab");
    }
    
    @Test
    void case6() {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain","hklf", "hf"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("oath","eat","hklf","hf");
    }
    
    @Test
    void case7() {
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = {"abcdefg", "gfedcbaaa", "eaabcdgfa", "befa", "dgc", "ade"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("abcdefg", "befa", "eaabcdgfa", "gfedcbaaa");
    }

    @Test
    void case8() {
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String[] words = {"eaafgdcba","eaabcdgfa"};
        sut = new WordSearcher();

//        List<String> result = sut.findWords(board, words);
        List<String> result = sut.findWords2(board, words);

        assertThat(result).containsExactlyInAnyOrder("eaabcdgfa","eaafgdcba");
    }
}
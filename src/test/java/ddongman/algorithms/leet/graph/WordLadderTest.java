package ddongman.algorithms.leet.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class WordLadderTest {

    private WordLadder sut;

    @Test
    void case1() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        sut = new WordLadder();

//        int result = sut.ladderLength(beginWord, endWord, wordList);
//        int result = sut.ladderLength2(beginWord, endWord, wordList);
//        int result = sut.ladderLength3(beginWord, endWord, wordList);
        int result = sut.ladderLength4(beginWord, endWord, wordList);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case2() {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
        sut = new WordLadder();

//        int result = sut.ladderLength(beginWord, endWord, wordList);
//        int result = sut.ladderLength2(beginWord, endWord, wordList);
//        int result = sut.ladderLength3(beginWord, endWord, wordList);
        int result = sut.ladderLength4(beginWord, endWord, wordList);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case3() {
        String beginWord = "hot", endWord = "dog";
        List<String> wordList = List.of("hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot");
        sut = new WordLadder();

//        int result = sut.ladderLength(beginWord, endWord, wordList);
//        int result = sut.ladderLength2(beginWord, endWord, wordList);
//        int result = sut.ladderLength3(beginWord, endWord, wordList);
        int result = sut.ladderLength4(beginWord, endWord, wordList);

        assertThat(result).isEqualTo(3);
    }
}
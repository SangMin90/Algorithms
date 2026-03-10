package ddongman.algorithms.doit.tree.trie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSetTest {

    private StringSet sut;

    @BeforeEach
    void setUp() {
        sut = new StringSet();
    }

    @Test
    void case1() {
        int N = 5;
        int M = 11;

        String[] words = new String[]{
                "baekjoononlinejudge",
                "startlink",
                "codeplus",
                "sundaycoding",
                "codingsh",
                "baekjoon",
                "codeplus",
                "codeminus",
                "startlink",
                "starlink",
                "sundaycoding",
                "codingsh",
                "codinghs",
                "sondaycoding",
                "startrink",
                "icerink",
        };

        int result = sut.solution(N, M, words);

        assertThat(result).isEqualTo(4);
    }
}
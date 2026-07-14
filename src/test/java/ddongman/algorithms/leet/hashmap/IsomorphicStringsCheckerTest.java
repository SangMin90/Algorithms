package ddongman.algorithms.leet.hashmap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IsomorphicStringsCheckerTest {

    private IsomorphicStringsChecker sut;

    @BeforeEach
    void setUp() {
        sut = new IsomorphicStringsChecker();
    }

    @Test
    void case1() {
        String s = "f11", t = "b23";

        boolean result = sut.isIsomorphic(s, t);

        assertThat(result).isFalse();
    }

    @Test
    void case2() {
        String s = "egg", t = "add";

        boolean result = sut.isIsomorphic(s, t);

        assertThat(result).isTrue();
    }

    @Test
    void case3() {
        String s = "paper", t = "title";

        boolean result = sut.isIsomorphic(s, t);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        String s = "badc", t = "baba";

        boolean result = sut.isIsomorphic(s, t);

        assertThat(result).isFalse();
    }
}
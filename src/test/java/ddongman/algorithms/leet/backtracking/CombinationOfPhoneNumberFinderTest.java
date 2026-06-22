package ddongman.algorithms.leet.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinationOfPhoneNumberFinderTest {

    private CombinationOfPhoneNumberFinder sut;

    @BeforeEach
    void setUp() {
        sut = new CombinationOfPhoneNumberFinder();
    }

    @Test
    void case1() {
        String digits = "23";

        List<String> result = sut.letterCombinations(digits);

        assertThat(result).containsExactly("ad","ae","af","bd","be","bf","cd","ce","cf");
    }

    @Test
    void case2() {
        String digits = "2";

        List<String> result = sut.letterCombinations(digits);

        assertThat(result).containsExactly("a", "b", "c");
    }
}
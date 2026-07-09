package ddongman.algorithms.leet.twopointer;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubsequenceCheckerTest {

    private SubsequenceChecker sut;

    @BeforeEach
    public void setUp() {
        sut = new SubsequenceChecker();
    }

    @Test
    void case1() {
        String s = "abc";
        String t = "ahbgdc";

//        boolean result = sut.isSubsequence(s, t);
        boolean result = sut.isSubsequence2(s, t);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        String s = "axc";
        String t = "ahbgdc";

//        boolean result = sut.isSubsequence(s, t);
        boolean result = sut.isSubsequence2(s, t);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        String s = "acb";
        String t = "ahbgdc";

//        boolean result = sut.isSubsequence(s, t);
        boolean result = sut.isSubsequence2(s, t);

        assertThat(result).isFalse();
    }

    @Test
    void case4() {
        String s = "rjufvjafbxnbgriwgokdgqdqewn";
        String t = "mjmqqjrmzkvhxlyruonekhhofpzzslupzojfuoztvzmmqvmlhgqxehojfowtrinbatjujaxekbcydldglkbxsqbbnrkhfdnpfbuaktupfftiljwpgglkjqunvithzlzpgikixqeuimmtbiskemplcvljqgvlzvnqxgedxqnznddkiujwhdefziydtquoudzxstpjjitmiimbjfgfjikkjycwgnpdxpeppsturjwkgnifinccvqzwlbmgpdaodzptyrjjkbqmgdrftfbwgimsmjpknuqtijrsnwvtytqqvookinzmkkkrkgwafohflvuedssukjgipgmypakhlckvizmqvycvbxhlljzejcaijqnfgobuhuiahtmxfzoplmmjfxtggwwxliplntkfuxjcnzcqsaagahbbneugiocexcfpszzomumfqpaiydssmihdoewahoswhlnpctjmkyufsvjlrflfiktndubnymenlmpyrhjxfdcq";

//        boolean result = sut.isSubsequence(s, t);
        boolean result = sut.isSubsequence2(s, t);

        assertThat(result).isFalse();
    }

    @Test
    void case5() {
        String s = "aaaaaa";
        String t = "bbaaaa";

//        boolean result = sut.isSubsequence(s, t);
        boolean result = sut.isSubsequence2(s, t);

        assertThat(result).isFalse();
    }

    @Test
    void case6() {
        String s = "aza";
        String t = "abzba";

//        boolean result = sut.isSubsequence(s, t);
        boolean result = sut.isSubsequence2(s, t);

        assertThat(result).isTrue();
    }
}
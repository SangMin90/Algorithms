package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LCSTest {

    private LCS sut;

    @Test
    void case1() {
        String X = "ACAYKP";
        String Y = "CAPCAK";
        sut = new LCS(X, Y);

        int length = sut.length();
        String lcs = sut.lcs();

        assertThat(length).isEqualTo(4);
        assertThat(new String[]{"ACAK"}).contains(lcs);
    }

    @Test
    void case2() {
        String X = "GAC";
        String Y = "AGCAT";
        sut = new LCS(X, Y);

        int length = sut.length();
        String lcs = sut.lcs();

        assertThat(length).isEqualTo(2);
        assertThat(new String[]{"AC", "GC", "GA"}).contains(lcs);
    }
}
package ddongman.algorithms.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DNAPasswordTest {

    private DNAPassword sut;

    @BeforeEach
    void setUp() {
        sut = new DNAPassword();
    }

    @Test
    void case1() {
        int s = 9;
        int p = 8;
        String dna = "CCTGGATTG";
        int[] passwordPolicy = new int[]{2, 0, 1, 1};

        int result = sut.solution(s, p, dna, passwordPolicy);

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void case2() {
        int s = 4;
        int p = 2;
        String dna = "GATA";
        int[] passwordPolicy = new int[]{1, 0, 0, 1};

        int result = sut.solution(s, p, dna, passwordPolicy);

        Assertions.assertThat(result).isEqualTo(2);
    }
}
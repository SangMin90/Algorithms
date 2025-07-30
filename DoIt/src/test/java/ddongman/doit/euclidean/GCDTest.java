package ddongman.doit.euclidean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GCDTest {

    private GCD sut;

    @BeforeEach
    void setUp() {
        sut = new GCD();
    }

    @Test
    void case1() {
        long n = 3;
        long m = 4;

        long result = sut.solution(n, m);

        assertThat(result).isEqualTo(1L);
    }

    @Test
    void case2() {
        long n = 3;
        long m = 6;

        long result = sut.solution(n, m);

        assertThat(result).isEqualTo(111L);
    }

    @Test
    void case3() {
        long n = 500000000000000000L;
        long m = 500000000000000002L;

        long result = sut.solution(n, m);

        assertThat(result).isEqualTo(11L);
    }
}
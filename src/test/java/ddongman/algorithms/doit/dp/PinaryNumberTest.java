package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PinaryNumberTest {

    private static PinaryNumber sut;

    @BeforeAll
    static void setUp() {
        sut = new PinaryNumber(90);
    }

    @Test
    void case1() {
        int N = 3;

        long result = sut.count(N);

        assertThat(result).isEqualTo(2);
    }
}
package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DerangementTest {

    private static Derangement sut;

    @BeforeAll
    static void setUp() {
        sut = new Derangement(1_000_000);
    }

    @Test
    void case1() {
        int N = 5;

        long result = sut.count(N);

        assertThat(result).isEqualTo(44L);
    }

    @Test
    void case2() {
        int N = 4;

        long result = sut.count(N);

        assertThat(result).isEqualTo(9L);
    }

    @Test
    void case3() {
        int N = 3;

        long result = sut.count(N);

        assertThat(result).isEqualTo(2L);
    }

    @Test
    void case4() {
        int N = 21;

        long result = sut.count(N);

        assertThat(result).isEqualTo(50944540L);
    }

    @Test
    void case5() {
        int N = 1_000_000;

        long result = sut.count(N);

        assertThat(result).isEqualTo(686000001L);
    }

    @Test
    void case6() {
        int N = 1;

        long result = sut.count(N);

        assertThat(result).isEqualTo(0L);
    }
}
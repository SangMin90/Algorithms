package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoByNTilingTest {

    private static TwoByNTiling sut;

    @BeforeAll
    static void setUp() {
        sut = new TwoByNTiling(1_000);
    }

    @Test
    void case1() {
        int n = 2;

        int result = sut.countTilingWaysTwoBy(n);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int n = 9;

        int result = sut.countTilingWaysTwoBy(n);

        assertThat(result).isEqualTo(55);
    }
}
package ddongman.doit.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FinderStrangePrimeNumberTest {

    private FinderStrangePrimeNumber sut;

    @BeforeEach
    void setUp() {
        sut = new FinderStrangePrimeNumber();
    }

    @Test
    void case1_V1() {
        int n = 4;

        long[] result = sut.solutionV1(n);

        assertThat(result).isEqualTo(new long[]{2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393});
    }

    @Test
    void case1_V2() {
        int n = 4;

        long[] result = sut.solutionV2(n);

        assertThat(result).isEqualTo(new long[]{2333, 2339, 2393, 2399, 2939, 3119, 3137, 3733, 3739, 3793, 3797, 5939, 7193, 7331, 7333, 7393});
    }
}
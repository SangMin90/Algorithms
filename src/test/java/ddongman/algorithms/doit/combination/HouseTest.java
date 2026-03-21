package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HouseTest {

    private static House sut;

    @BeforeAll
    static void setUp() {
        sut = new House(28);
    }

    @Test
    void case1() {
        int K = 1;
        int N = 3;

        long result = sut.countHouseHolds(K, N);

        assertThat(result).isEqualTo(6L);
    }

    @Test
    void case2() {
        int K = 2;
        int N = 3;

        long result = sut.countHouseHolds(K, N);

        assertThat(result).isEqualTo(10L);
    }
}
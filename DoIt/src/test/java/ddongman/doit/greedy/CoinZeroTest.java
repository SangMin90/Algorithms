package ddongman.doit.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoinZeroTest {

    private CoinZero sut;

    @BeforeEach
    void setUp() {
        sut = new CoinZero();
    }

    @Test
    void case1() {
        int n = 10;
        int k = 4200;
        int[] coins = new int[]{1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};

        int result = sut.solution(n, k, coins);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    void case2() {
        int n = 10;
        int k = 4790;
        int[] coins = new int[]{1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};

        int result = sut.solution(n, k, coins);

        Assertions.assertThat(result).isEqualTo(12);
    }
}
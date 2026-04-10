package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BuildingOrderCalculatorTest {

    private BuildingOrderCalculator sut;

    @Test
    void case1() {
        int N = 3;
        int L = 2;
        int R = 2;
        sut = new BuildingOrderCalculator(N);

        int result = sut.count(N, L, R);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int N = 3;
        int L = 2;
        int R = 1;
        sut = new BuildingOrderCalculator(N);

        int result = sut.count(N, L, R);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int N = 5;
        int L = 3;
        int R = 2;
        sut = new BuildingOrderCalculator(N);

        int result = sut.count(N, L, R);

        assertThat(result).isEqualTo(18);
    }

    @Test
    void case4() {
        int N = 12;
        int L = 1;
        int R = 1;
        sut = new BuildingOrderCalculator(N);

        int result = sut.count(N, L, R);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case5() {
        int N = 8;
        int L = 3;
        int R = 2;
        sut = new BuildingOrderCalculator(N);

        int result = sut.count(N, L, R);

        assertThat(result).isEqualTo(4872);
    }
}
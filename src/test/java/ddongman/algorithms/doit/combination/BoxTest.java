package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoxTest {

    private Box sut;

    @Test
    void case1() {
        int M = 1;
        int[] countOfPebbles = new int[]{13};
        int K = 8;
        sut = new Box(countOfPebbles);

        double result = sut.calculateProbabilityOfSameColor(K);

        assertThat(result).isEqualTo(1.0);
    }

    @Test
    void case2() {
        int M = 2;
        int[] countOfPebbles = new int[]{5, 7};
        int K = 1;
        sut = new Box(countOfPebbles);

        double result = sut.calculateProbabilityOfSameColor(K);

        assertThat(result).isEqualTo(1.0);
    }

    @Test
    void case3() {
        int M = 3;
        int[] countOfPebbles = new int[]{5, 6, 7};
        int K = 2;
        sut = new Box(countOfPebbles);

        double result = sut.calculateProbabilityOfSameColor(K);

        assertThat(result).isEqualTo(0.30065359477124187);
    }

    @Test
    void case4() {
        int M = 5;
        int[] countOfPebbles = new int[]{12, 2, 34, 13, 17};
        int K = 4;
        sut = new Box(countOfPebbles);

        double result = sut.calculateProbabilityOfSameColor(K);

        assertThat(result).isEqualTo(0.035028830818304504);
    }
}
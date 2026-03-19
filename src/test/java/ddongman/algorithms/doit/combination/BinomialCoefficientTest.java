package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinomialCoefficientTest {

    private BinomialCoefficient sut;

    @Test
    void case1() {
        int N = 5;
        int K = 2;
        sut = new BinomialCoefficient(N);

        int result = sut.combination(N, K);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void case2() {
        int N = 0;
        int K = 0;
        sut = new BinomialCoefficient(N);

        int result = sut.combination(N, K);

        assertThat(result).isEqualTo(1);
    }
}
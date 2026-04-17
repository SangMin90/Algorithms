package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LISTest {

    private LIS sut;

    @Test
    void case1() {
        int N = 6;
        int[] sequence = new int[]{10, 20, 10, 30, 20, 50};
        sut = new LIS(N);

        int[] result = sut.find(sequence);

        assertThat(result).isEqualTo(new int[]{10, 20, 30, 50});
    }

    @Test
    void case2() {
        int N = 10;
        int[] sequence = new int[]{11, 5, 10, 12, 7, 14, 3, 8, 24, 2};
        sut = new LIS(N);

        int[] result = sut.find(sequence);

        assertThat(result).isEqualTo(new int[]{5, 10, 12, 14, 24});
    }
}
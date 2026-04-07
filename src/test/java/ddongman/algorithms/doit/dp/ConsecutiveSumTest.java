package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveSumTest {

    private ConsecutiveSum sut;

    @Test
    void case1() {
        int N = 10;
        int[] elements = new int[]{10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        sut = new ConsecutiveSum(N);

        int result = sut.max(elements);

        assertThat(result).isEqualTo(54);
    }

    @Test
    void case2() {
        int N = 1;
        int[] elements = new int[]{-4};
        sut = new ConsecutiveSum(N);

        int result = sut.max(elements);

        assertThat(result).isEqualTo(-4);
    }

    @Test
    void case3() {
        int N = 2;
        int[] elements = new int[]{-236, -344};
        sut = new ConsecutiveSum(N);

        int result = sut.max(elements);

        assertThat(result).isEqualTo(-236);
    }
}
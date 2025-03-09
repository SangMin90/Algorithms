package ddongman.doit.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KthNumberTest {

    private KthNumber sut;

    @BeforeEach
    void setUp() {
        sut = new KthNumber();
    }

    @Test
    void case1() {
        int n = 5;
        int k = 2;
        int[] numbers = new int[]{4, 1, 2, 3, 5};

        int result = sut.solutionMedian(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int n = 9;
        int k = 2;
        int[] numbers = new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7};

        int result = sut.solutionMedian(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int n = 7;
        int k = 2;
        int[] numbers = new int[]{5, 3, 7, 6, 2, 1, 4};

        int result = sut.solutionMedian(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case1_V2() {
        int n = 5;
        int k = 2;
        int[] numbers = new int[]{4, 1, 2, 3, 5};

        int result = sut.solutionLeft(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2_V2() {
        int n = 9;
        int k = 2;
        int[] numbers = new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7};

        int result = sut.solutionLeft(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3_V2() {
        int n = 7;
        int k = 2;
        int[] numbers = new int[]{5, 3, 7, 6, 2, 1, 4};

        int result = sut.solutionLeft(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case1_V3() {
        int n = 5;
        int k = 2;
        int[] numbers = new int[]{4, 1, 2, 3, 5};

        int result = sut.solutionRight(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2_V3() {
        int n = 9;
        int k = 2;
        int[] numbers = new int[]{5, 3, 8, 4, 9, 1, 6, 2, 7};

        int result = sut.solutionRight(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3_V3() {
        int n = 7;
        int k = 2;
        int[] numbers = new int[]{5, 3, 7, 6, 2, 1, 4};

        int result = sut.solutionRight(n, k, numbers);

        assertThat(result).isEqualTo(2);
    }
}
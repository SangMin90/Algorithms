package ddongman.doit.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrefixSumTest {

    private PrefixSum sut;

    @BeforeEach
    void setUp() {
        sut = new PrefixSum();
    }

    @Test
    void arrayV1_case1() {
        int n = 5;
        int q = 3;
        int[] numbers = new int[]{5, 4, 3, 2, 1};
        int[][] queries = new int[][]{{1, 3}, {2, 4}, {5, 5}};

        int[] result = sut.ofArrayV1(n, q, numbers, queries);

        assertThat(result).isEqualTo(new int[]{12, 9, 1});
    }

    @Test
    void arrayV2_case1() {
        int n = 5;
        int q = 3;
        int[] numbers = new int[]{5, 4, 3, 2, 1};
        int[][] queries = new int[][]{{1, 3}, {2, 4}, {5, 5}};

        int[] result = sut.ofArrayV2(n, q, numbers, queries);

        assertThat(result).isEqualTo(new int[]{12, 9, 1});
    }

    @Test
    void matrixV1_case1() {
        int n = 4;
        int q = 3;
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        int[][] queries = new int[][]{{2, 2, 3, 4}, {3, 4, 3, 4}, {1, 1, 4, 4}};

        int[] result = sut.ofMatrixV1(n, q, matrix, queries);

        assertThat(result).isEqualTo(new int[]{27, 6, 64});
    }

    @Test
    void matrixV2_case1() {
        int n = 4;
        int q = 3;
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        int[][] queries = new int[][]{{2, 2, 3, 4}, {3, 4, 3, 4}, {1, 1, 4, 4}};

        int[] result = sut.ofMatrixV2(n, q, matrix, queries);

        assertThat(result).isEqualTo(new int[]{27, 6, 64});
    }
}
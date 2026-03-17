package ddongman.algorithms.doit.tree.segment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeMultiplyQueryTest {

    private RangeMultiplyQuery sut;

    @BeforeEach
    void setUp() {
        sut = new RangeMultiplyQuery();
    }

    @Test
    void case1() {
        int N = 5;
        int M = 2;
        int K = 2;
        int[] elements = new int[]{1, 2, 3, 4, 5};
        int[][] missions = new int[][]{
                {1, 3, 6},
                {2, 2, 5},
                {1, 5, 2},
                {2, 3, 5},
        };

        long[] result = sut.solution(N, M, K, elements, missions);

        assertThat(result).isEqualTo(new long[]{240, 48});
    }

    @Test
    void case2() {
        int N = 5;
        int M = 2;
        int K = 2;
        int[] elements = new int[]{1,2,3,4,5};
        int[][] missions = new int[][]{
                {1, 3, 0},
                {2, 2, 5},
                {1, 3, 6},
                {2, 2, 5},
        };

        long[] result = sut.solution(N, M, K, elements, missions);

        assertThat(result).isEqualTo(new long[]{0, 240});
    }

    @Test
    void case3() {
        int N = 10;
        int M = 5;
        int K = 2;
        int[] elements = new int[]{804, 771, 748, 926, 782, 854, 808, 270, 739, 718};
        int[][] missions = new int[][]{
                {1, 2, 939},
                {1, 8, 763},
                {2, 2, 10},
                {1, 1, 196},
                {1, 7, 472},
                {1, 5, 212},
                {2, 6, 8},
        };

        long[] result = sut.solution(N, M, K, elements, missions);

        assertThat(result).isEqualTo(new long[]{181830060, 307556144});
    }
    
    @Test
    void case4() {
        int N = 9;
        int M = 1;
        int K = 7;
        int[] elements = new int[]{24, 905, 32, 114, 745, 839, 382, 223, 379};
        int[][] missions = new int[][]{
                {2, 2, 4},
                {2, 9, 9},
                {1, 4, 718},
                {2, 1, 5},
                {2, 3, 8},
                {2, 3, 4},
                {2, 1, 8},
                {2, 8, 9},
        };

        long[] result = sut.solution(N, M, K, elements, missions);

        assertThat(result).isEqualTo(new long[]{3301440, 379, 783843803, 599280834, 22976, 379623368, 84517});

    }
}
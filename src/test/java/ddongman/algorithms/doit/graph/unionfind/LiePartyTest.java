package ddongman.algorithms.doit.graph.unionfind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LiePartyTest {

    private LieParty sut;

    @BeforeEach
    void setUp() {
        sut = new LieParty();
    }

    @Test
    void case1() {
        int N = 4;
        int M = 3;
        int[] truthInfo = new int[]{0};
        int[][] parties = new int[][]{
                {1, 2},
                {3},
                {2, 3, 4}
        };

        int result = sut.solution(N, M, truthInfo, parties);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int N = 4;
        int M = 1;
        int[] truthInfo = new int[]{1, 1};
        int[][] parties = new int[][]{
                {1, 2, 3, 4}
        };

        int result = sut.solution(N, M, truthInfo, parties);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case3() {
        int N = 4;
        int M = 1;
        int[] truthUnion = new int[]{0};
        int[][] parties = new int[][]{
                {1, 2, 3, 4}
        };

        int result = sut.solution(N, M, truthUnion, parties);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        int N = 4;
        int M = 5;
        int[] truthInfo = new int[]{1, 1};
        int[][] parties = new int[][]{
                {1},
                {2},
                {3},
                {4},
                {4, 1}
        };

        int result = sut.solution(N, M, truthInfo, parties);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case5() {
        int N = 10;
        int M = 9;
        int[] truthInfo = new int[]{4, 1, 2, 3, 4};
        int[][] parties = new int[][]{
                {1, 5},
                {2, 6},
                {7},
                {8},
                {7, 8},
                {9},
                {10},
                {3, 10},
                {4}
        };

        int result = sut.solution(N, M, truthInfo, parties);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case6() {
        int N = 8;
        int M = 5;
        int[] truthInfo = new int[]{3, 1, 2, 7};
        int[][] parties = new int[][]{
                {3, 4},
                {5},
                {5, 6},
                {6, 8},
                {8}
        };

        int result = sut.solution(N, M, truthInfo, parties);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case7() {
        int N = 3;
        int M = 4;
        int[] truthInfo = new int[]{1, 3};
        int[][] parties = new int[][]{
                {1},
                {2},
                {1, 2},
                {1, 2, 3}
        };

        int result = sut.solution(N, M, truthInfo, parties);

        assertThat(result).isEqualTo(0);
    }
}
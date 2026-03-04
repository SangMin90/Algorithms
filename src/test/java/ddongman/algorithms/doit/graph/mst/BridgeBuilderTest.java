package ddongman.algorithms.doit.graph.mst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeBuilderTest {

    private BridgeBuilder sut;

    @BeforeEach
    void setUp() {
        sut = new BridgeBuilder();
    }

    @Test
    void case1() {
        int N = 7;
        int M = 8;
        int[][] map = new int[][]{
                {0, 0, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };

        int result = sut.solution(N, M, map);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void case2() {

        int N = 7;
        int M = 8;
        int[][] map = new int[][]{
                {0, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };

        int result = sut.solution(N, M, map);

        assertThat(result).isEqualTo(10);
    }

    @Test
    void case3() {
        int N = 7;
        int M = 8;
        int[][] map = new int[][]{
                {1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 0, 0},
        };

        int result = sut.solution(N, M, map);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void case4() {
        int N = 7;
        int M = 7;
        int[][] map = new int[][]{
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1},
        };

        int result = sut.solution(N, M, map);

        assertThat(result).isEqualTo(-1);
    }
}
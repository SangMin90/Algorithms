package ddongman.algorithms.doit.graph.bellman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BellmanFordTest {

    private BellmanFord sut;

    @BeforeEach
    void setUp() {
        sut = new BellmanFord();
    }

    @Test
    void case1() {
        int V = 3;
        int E = 4;
        int[][] graph = new int[][]{
                {1, 2, 4},
                {1, 3, 3},
                {2, 3, -1},
                {3, 1, -2},
        };
        int start = 1;

        long[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new long[]{4, 3});
    }

    @Test
    void case2() {
        int V = 3;
        int E = 4;
        int[][] graph = new int[][]{
                {1, 2, 4},
                {1, 3, 3},
                {2, 3, -4},
                {3, 1, -2},
        };

        int start = 1;

        long[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new long[]{-1});
    }

    @Test
    void case3() {
        int V = 3;
        int E = 2;
        int[][] graph = new int[][]{
                {1, 2, 4},
                {1, 2, 3},
        };

        int start = 1;

        long[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new long[]{3, -1});
    }
}
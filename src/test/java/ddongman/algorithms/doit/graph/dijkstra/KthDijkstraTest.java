package ddongman.algorithms.doit.graph.dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KthDijkstraTest {

    private KthDijkstra sut;

    @BeforeEach
    void setUp() {
        sut = new KthDijkstra();
    }

    @Test
    void case1() {
        int n = 5;
        int m = 10;
        int k = 2;
        int[][] graph = new int[][]{
                {1, 2, 2},
                {1, 3, 7},
                {1, 4, 5},
                {1, 5, 6},
                {2, 4, 2},
                {2, 3, 4},
                {3, 4, 6},
                {3, 5, 8},
                {5, 2, 4},
                {5, 4, 1},
        };

        int[] result = sut.solution(n, m, k, graph);

        assertThat(result).isEqualTo(new int[]{-1, 10, 7, 5, 14});
    }

    @Test
    void case2() {
        int n = 4;
        int m = 4;
        int k = 2;
        int[][] graph = new int[][]{
                {1, 2, 1},
                {2, 4, 3},
                {1, 3, 3},
                {3, 4, 1},
        };

        int[] result = sut.solution(n, m, k, graph);

        assertThat(result).isEqualTo(new int[]{-1, -1, -1, 4});
    }

    @Test
    void case3() {
        int n = 5;
        int m = 5;
        int k = 3;
        int[][] graph = new int[][]{
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4},
                {5, 5, 5},
        };

        int[] result = sut.solution(n, m, k, graph);

        assertThat(result).isEqualTo(new int[]{2, -1, -1, -1, -1});
    }
}
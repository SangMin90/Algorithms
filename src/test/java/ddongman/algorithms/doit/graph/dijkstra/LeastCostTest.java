package ddongman.algorithms.doit.graph.dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LeastCostTest {

    private LeastCost sut;

    @BeforeEach
    void setUp() {
        sut = new LeastCost();
    }

    @Test
    void case1() {
        int N = 5;
        int M = 8;
        int[][] graph = new int[][]{
                {1, 2, 2},
                {1, 3, 3},
                {1, 4, 1},
                {1, 5, 10},
                {2, 4, 2},
                {3, 4, 1},
                {3, 5, 1},
                {4, 5, 3},
        };
        int from = 1;
        int to = 5;

        int result = sut.solution(N, M, graph, from, to);

        assertThat(result).isEqualTo(4);
    }

}
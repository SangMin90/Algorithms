package ddongman.algorithms.doit.graph.bellman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class KevinBaconTest {

    private KevinBacon sut;

    @BeforeEach
    void setUp() {
        sut = new KevinBacon();
    }

    @Test
    void case1() {
        int N = 5;
        int M = 5;
        int[][] graph = new int[][]{
                {1, 3},
                {1, 4},
                {4, 5},
                {4, 3},
                {3, 2},
        };

        int result = sut.solution(N, M, graph);

        assertThat(result).isEqualTo(3);
    }
}
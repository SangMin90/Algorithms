package ddongman.algorithms.doit.graph.mst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MSTTest {

    private MST sut;

    @BeforeEach
    void setUp() {
        sut = new MST();
    }

    @Test
    void case1() {
        int V = 3;
        int E = 3;
        int[][] graph = new int[][]{
                {1, 2, 1},
                {2, 3, 2},
                {1, 3, 3},
        };

        long result = sut.solution(V, E, graph);

        assertThat(result).isEqualTo(3L);
    }
}
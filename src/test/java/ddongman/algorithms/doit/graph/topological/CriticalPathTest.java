package ddongman.algorithms.doit.graph.topological;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CriticalPathTest {

    private CriticalPath sut;

    @BeforeEach
    void setUp() {
        sut = new CriticalPath();
    }

    @Test
    void case1() {
        int n = 7;
        int m = 9;
        int[][] graph = new int[][]{
                {1, 2, 4},
                {1, 3, 2},
                {1, 4, 3},
                {2, 6, 3},
                {2, 7, 5},
                {3, 5, 1},
                {4, 6, 4},
                {5, 6, 2},
                {6, 7, 5},
        };
        int start = 1;
        int end = 7;

        int[] result = sut.solution(n, m, graph, start, end);

        assertThat(result).isEqualTo(new int[]{12, 5});
    }

}
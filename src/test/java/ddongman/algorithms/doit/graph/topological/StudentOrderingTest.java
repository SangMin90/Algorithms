package ddongman.algorithms.doit.graph.topological;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StudentOrderingTest {

    private StudentOrdering sut;

    @BeforeEach
    void setUp() {
        sut = new StudentOrdering();
    }

    @Test
    void case1() {
        int N = 3;
        int M = 2;
        int[][] graph = new int[][]{
                {1, 3},
                {2, 3}
        };

        int[] result = sut.solution(N, M, graph);

        assertThat(result).isEqualTo(new int[]{1, 2, 3});
    }

    @Test
    void case2() {
        int N = 4;
        int M = 2;
        int[][] graph = new int[][]{
                {4, 2},
                {3, 1}
        };

        int[] result = sut.solution(N, M, graph);

        assertThat(result).isEqualTo(new int[]{3, 4, 1, 2});
    }

}
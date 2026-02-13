package ddongman.algorithms.doit.graph.floyd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FloydWarshallTest {

    private FloydWarshall sut;

    @BeforeEach
    void setUp() {
        sut = new FloydWarshall();
    }

    @Test
    void case1() {
        int n = 5;
        int m = 14;
        int[][] graph = new int[][]{
                {1, 2, 2},
                {1, 3, 3},
                {1, 4, 1},
                {1, 5, 10},
                {2, 4, 2},
                {3, 4, 1},
                {3, 5, 1},
                {4, 5, 3},
                {3, 5, 10},
                {3, 1, 8},
                {1, 4, 2},
                {5, 1, 7},
                {3, 4, 2},
                {5, 2, 4},
        };

        long[][] result = sut.solution(n, graph);

        assertThat(result).isEqualTo(new long[][]{
                {0, 2, 3, 1, 4},
                {12, 0, 15, 2, 5},
                {8, 5, 0, 1, 1},
                {10, 7, 13, 0, 3},
                {7, 4, 10, 6, 0},
        });
    }

    @Test
    void case2() {
        int n = 3;
        int m = 2;
        int[][] graph = new int[][]{
                {1, 2, 100000},
                {2, 3, 100000},
        };

        long[][] result = sut.solution(n, graph);

        assertThat(result).isEqualTo(new long[][]{
                {0, 100000, 200000},
                {10_000_000, 0, 100000},
                {10_000_000, 10_000_000, 0},
        });
    }
}
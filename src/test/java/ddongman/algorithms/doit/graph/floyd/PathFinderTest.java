package ddongman.algorithms.doit.graph.floyd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PathFinderTest {

    private PathFinder sut;

    @BeforeEach
    void setUp() {
        sut = new PathFinder();
    }

    @Test
    void case1() {
        int N = 3;
        int[][] graph = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0},
        };

        long[][] result = sut.solution(N, graph);

        assertThat(result).isEqualTo(new long[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        });
    }

    @Test
    void case2() {
        int N = 7;
        int[][] graph = new int[][]{
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0},
        };

        long[][] result = sut.solution(N, graph);

        assertThat(result).isEqualTo(new long[][]{
                {1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 0},
        });
    }
}
package ddongman.algorithms.doit.graph.topological;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameDevelopmentTest {

    private GameDevelopment sut;

    @BeforeEach
    void setUp() {
        sut = new GameDevelopment();
    }

    @Test
    void case1() {
        int N = 5;
        int[][] graph = new int[][]{
                {10, -1},
                {10, 1, -1},
                {4, 1, -1},
                {4, 3, 1, -1},
                {3, 3, -1}
        };

        int[] result = sut.solution(N, graph);

        assertThat(result).isEqualTo(new int[]{10, 20, 14, 18, 17});
    }

    @Test
    void case2() {
        int N = 5;
        int[][] graph = new int[][]{
                {10, -1},
                {10, -1},
                {4, 1, -1},
                {4, 3, 2, -1},
                {3, 3, -1}
        };

        int[] result = sut.solution(N, graph);

        assertThat(result).isEqualTo(new int[]{10, 10, 14, 18, 17});
    }
}
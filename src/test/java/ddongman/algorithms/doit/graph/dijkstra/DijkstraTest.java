package ddongman.algorithms.doit.graph.dijkstra;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstraTest {

    private Dijkstra sut;

    @BeforeEach
    void setUp() {
        sut = new Dijkstra();
    }

    @Test
    void case1() {
        int V = 5;
        int E = 6;
        int start = 1;
        int[][] graph = new int[][]{
                {5, 1, 1},
                {1, 2, 2},
                {1, 3, 3},
                {2, 3, 4},
                {2, 4, 5},
                {3, 4, 6}
        };

        Object[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new Object[]{0, 2, 3, 7, "INF"});
    }

    @Test
    void case2() {
        int V = 3;
        int E = 1;
        int start = 1;
        int[][] graph = new int[][]{
                {2, 3, 1},
        };

        Object[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new Object[]{0, "INF", "INF"});
    }

    @Test
    void case3() {
        int V = 3;
        int E = 2;
        int start = 1;
        int[][] graph = new int[][]{
                {1, 2, 1},
                {3, 2, 1},
        };

        Object[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new Object[]{0, 1, "INF"});
    }

    @Test
    void case4() {
        int V = 3;
        int E = 3;
        int start = 1;
        int[][] graph = new int[][]{
                {1, 2, 1},
                {3, 2, 10},
                {2, 3, 10},
        };

        Object[] result = sut.solution(V, E, start, graph);

        assertThat(result).isEqualTo(new Object[]{0, 1, 11});
    }
}
package ddongman.algorithms.doit.graph.bellman;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SalesmanTest {

    private Salesman sut;

    @BeforeEach
    void setUp() {
        sut = new Salesman();
    }

    @Test
    void case1() {
        int N = 5;
        int start = 0;
        int end = 4;
        int M = 7;
        int[][] graph = new int[][]{
                {0, 1, 13},
                {1, 2, 17},
                {2, 4, 20},
                {0, 3, 22},
                {1, 3, 4747},
                {2, 0, 10},
                {3, 4, 10},
        };
        int[] sales = new int[]{0, 0, 0, 0, 0};

        Object result = sut.solution(N, start, end, M, graph, sales);

        assertThat(result).isEqualTo(-32L);
    }

    @Test
    void case2() {
        int N = 5;
        int start = 0;
        int end = 4;
        int M = 5;
        int[][] graph = new int[][]{
                {0, 1, 10},
                {1, 2, 10},
                {2, 3, 10},
                {3, 1, 10},
                {2, 4, 10},
        };
        int[] sales = new int[]{0, 10, 10, 110, 10};

        Object result = sut.solution(N, start, end, M, graph, sales);

        assertThat(result).isEqualTo("Gee");
    }

    @Test
    void case3() {
        int N = 3;
        int start = 0;
        int end = 2;
        int M = 3;
        int[][] graph = new int[][]{
                {0, 1, 10},
                {1, 0, 10},
                {2, 1, 10},
        };
        int[] sales = new int[]{1000, 1000, 47000};

        Object result = sut.solution(N, start, end, M, graph, sales);

        assertThat(result).isEqualTo("gg");
    }

    @Test
    void case4() {
        int N = 2;
        int start = 0;
        int end = 1;
        int M = 2;
        int[][] graph = new int[][]{
                {0, 1, 1000},
                {1, 1, 10},
        };
        int[] sales = new int[]{11, 11};

        Object result = sut.solution(N, start, end, M, graph, sales);

        assertThat(result).isEqualTo("Gee");
    }

    @Test
    void case5() {
        int N = 1;
        int start = 0;
        int end = 0;
        int M = 1;
        int[][] graph = new int[][]{
                {0, 0, 10}
        };
        int[] sales = new int[]{7};

        Object result = sut.solution(N, start, end, M, graph, sales);

        assertThat(result).isEqualTo(7L);
    }

    @Test
    void case6() {
        int N = 5;
        int start = 0;
        int end = 4;
        int M = 7;
        int[][] graph = new int[][]{
                {0, 1, 13},
                {1, 2, 17},
                {2, 4, 20},
                {0, 3, 22},
                {1, 3, 4747},
                {2, 0, 10},
                {3, 4, 10},
        };
        int[] sales = new int[]{8, 10, 20, 1, 100000};

        Object result = sut.solution(N, start, end, M, graph, sales);

        assertThat(result).isEqualTo(99988L);
    }

    @Test
    void case7() {
        int N = 4;
        int start = 0;
        int end = 1;
        int M = 4;
        int[][] graph = new int[][]{
                {0, 1, 0},
                {3, 1, 10},
                {2, 3, 3},
                {3, 2, 3},
        };
        int[] sales = new int[]{0, 10, 10, 10};

        Object solution = sut.solution(N, start, end, M, graph, sales);

        assertThat(solution).isEqualTo(10L);
    }
}
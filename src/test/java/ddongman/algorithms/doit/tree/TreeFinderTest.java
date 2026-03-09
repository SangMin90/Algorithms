package ddongman.algorithms.doit.graph.tree;

import ddongman.algorithms.doit.tree.TreeFinder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeFinderTest {

    private TreeFinder sut;

    @BeforeEach
    void setUp() {
        sut = new TreeFinder();
    }

    @Test
    void case1() {
        int N = 7;
        int[][] graph = new int[][]{
                {1, 6},
                {6, 3},
                {3, 5},
                {4, 1},
                {2, 4},
                {4, 7},
        };

        int[] result = sut.solution(N, graph);

        assertThat(result).isEqualTo(new int[]{4, 6, 1, 3, 1, 4});
    }

    @Test
    void case2() {
        int N = 12;
        int[][] graph = new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {3, 5},
                {3, 6},
                {4, 7},
                {4, 8},
                {5, 9},
                {5, 10},
                {6, 11},
                {6, 12},
        };

        int[] result = sut.solution(N, graph);

        assertThat(result).isEqualTo(new int[]{1, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6});
    }
}
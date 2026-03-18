package ddongman.algorithms.doit.tree.lca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LCATest {

    private LCA sut;

    @BeforeEach
    void setUp() {
        sut = new LCA();
    }

    @Test
    void case1() {
        int N = 15;
        int[][] edges = new int[][]{
                {1, 2},
                {1, 3},
                {2, 4},
                {3, 7},
                {6, 2},
                {3, 8},
                {4, 9},
                {2, 5},
                {5, 11},
                {7, 13},
                {10, 4},
                {11, 15},
                {12, 5},
                {14, 7},
        };
        int M = 6;
        int[][] queries = new int[][]{
                {6, 11},
                {10, 9},
                {2, 6},
                {7, 6},
                {8, 13},
                {8, 15},
        };

        int[] result = sut.solution(N, edges, M, queries);

        assertThat(result).isEqualTo(new int[]{2, 4, 2, 1, 3, 1});
    }
}
package ddongman.algorithms.doit.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BFSTest {

    private BFS sut;

    @BeforeEach
    void setUp() {
        sut = new BFS();
    }

    @Test
    void case1() {
        int n = 4;
        int m = 5;
        int v = 1;
        int[][] arr = new int[][]{{1, 2}, {1, 3}, {1, 4}, {2, 4}, {3, 4}};

        int[] result = sut.solution(n, m, v, arr);

        assertThat(result).isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    void case2() {
        int n = 5;
        int m = 5;
        int v = 3;
        int[][] arr = new int[][]{{5, 4},{5, 2},{1, 2},{3, 4},{3, 1}};

        int[] result = sut.solution(n, m, v, arr);

        assertThat(result).isEqualTo(new int[]{3, 1, 4, 2, 5});
    }

    @Test
    void case3() {
        int n = 1000;
        int m = 1;
        int v = 1000;
        int[][] arr = new int[][]{{999, 1000}};

        int[] result = sut.solution(n, m, v, arr);

        assertThat(result).isEqualTo(new int[]{1000, 999});
    }
}
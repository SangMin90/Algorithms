package ddongman.algorithms.doit.graph.unionfind;

import ddongman.algorithms.doit.graph.unionfind.UnionFind.YN;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ddongman.algorithms.doit.graph.unionfind.UnionFind.YN.YES;
import static ddongman.algorithms.doit.graph.unionfind.UnionFind.YN.NO;
import static org.assertj.core.api.Assertions.assertThat;

class UnionFindTest {

    private UnionFind sut;

    @BeforeEach
    void setUp() {
        sut = new UnionFind();
    }

    @Test
    void case1() {
        int n = 7;
        int m = 8;
        int[][] operations = new int[][]{
                {0, 1, 3},
                {1, 1, 7},
                {0, 7, 6},
                {1, 7, 1},
                {0, 3, 7},
                {0, 4, 2},
                {0, 1, 1},
                {1, 1, 1},
        };

        YN[] result = sut.solution(n, m, operations);

        assertThat(result).isEqualTo(new YN[]{NO, NO, YES});
    }
}
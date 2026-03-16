package ddongman.algorithms.doit.tree.segment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RangeMinimumQueryTest {

    private RangeMinimumQuery sut;

    @BeforeEach
    void setUp() {
        sut = new RangeMinimumQuery();
    }

    @Test
    void case1() {
        int N = 10;
        int M = 4;
        int[] elements = new int[]{75, 30, 100, 38, 50, 51, 52, 20, 81, 5};
        int[][] queries = new int[][]{
                {1, 10},
                {3, 5},
                {6, 9},
                {8, 10},
        };

        int[] result = sut.solution(N, M, elements, queries);

        assertThat(result).isEqualTo(new int[]{5, 38, 20, 5});
    }
}
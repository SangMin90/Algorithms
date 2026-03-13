package ddongman.algorithms.doit.tree.segment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SegmentTreeTest {

    private SegmentTree sut;

    @BeforeEach
    void setUp() {
        sut = new SegmentTree();
    }

    @Test
    void case1() {
        long N = 5;
        long M = 2;
        long K = 2;
        long[] elements = new long[]{1, 2, 3, 4, 5};
        long[][] missions = new long[][]{
                {1, 3, 6},
                {2, 2, 5},
                {1, 5, 2},
                {2, 3, 5},
        };

        long[] result = sut.solution(N, M, K, elements, missions);

        assertThat(result).isEqualTo(new long[]{17, 12});
    }
}
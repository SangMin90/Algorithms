package ddongman.algorithms.doit.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeDiameterTest {

    private TreeDiameter sut;

    @BeforeEach
    void setUp() {
        sut = new TreeDiameter();
    }

    @Test
    void case1() throws Exception {
        //given
        int n = 5;
        int[][] edges = new int[][]{
                {1, 3, 2, -1},
                {2, 4, 4, -1},
                {3, 1, 2, 4, 3, -1},
                {4, 2, 4, 3, 3, 5, 6, -1},
                {5, 4, 6, -1}
        };

        //when
        int result = sut.solution(n, edges);

        //then
        assertThat(result).isEqualTo(11);
    }
}
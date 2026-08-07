package ddongman.algorithms.doit.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeafNodeFinderTest {

    private LeafNodeFinder sut;

    @BeforeEach
    void setUp() {
        sut = new LeafNodeFinder();
    }

    @Test
    void case1() {
        int N = 5;
        int[] parents = new int[]{-1, 0, 0, 1, 1};
        int targetNode = 2;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(2);
    }
    
    @Test
    void case2() {
        int N = 5;
        int[] parents = new int[]{-1, 0, 0, 1, 1};
        int targetNode = 1;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int N = 5;
        int[] parents = new int[]{-1, 0, 0, 1, 1};
        int targetNode = 0;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int N = 9;
        int[] parents = new int[]{-1, 0, 0, 2, 2, 4, 4, 6, 6};
        int targetNode = 4;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case5() {
        int N = 4;
        int[] parents = new int[]{1, 3, 0, -1};
        int targetNode = 1;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case6() {
        int N = 4;
        int[] parents = new int[]{-1, 0, 0, 1};
        int targetNode = 3;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case7() {
        int N = 4;
        int[] parents = new int[]{1, 3, 0, -1};
        int targetNode = 2;

        int result = sut.solution(N, parents, targetNode);

        assertThat(result).isEqualTo(1);
    }
}
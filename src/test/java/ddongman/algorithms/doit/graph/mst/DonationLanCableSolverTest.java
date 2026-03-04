package ddongman.algorithms.doit.graph.mst;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DonationLanCableSolverTest {

    private DonationLanCableSolver sut;

    @BeforeEach
    void setUp() {
        sut = new DonationLanCableSolver();
    }

    @Test
    void case1() {
        int N = 3;
        char[][] graph = new char[][]{
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
        };

        int result = sut.solution(N, graph);

        assertThat(result).isEqualTo(40);
    }

    @Test
    void case2() {
        int N = 2;
        char[][] graph = new char[][]{
                {'a', '0'},
                {'0', 'b'},
        };

        int result = sut.solution(N, graph);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void case3() {
        int N = 4;
        char[][] graph = new char[][]{
                {'0', 'X', '0', '0'},
                {'0', '0', 'Y', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', 'Z', '0'},
        };

        int result = sut.solution(N, graph);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int N = 2;
        char[][] graph = new char[][]{
                {'A','z'},
                {'a','Z'},
        };

        int result = sut.solution(N, graph);

        assertThat(result).isEqualTo(105);
    }

    @Test
    void case5() {
        int N = 4;
        char[][] graph = new char[][]{
                {'0', 't', 'o', 'p'},
                {'c', '0', 'o', 'd'},
                {'e', 'r', '0', 'o'},
                {'p', 'e', 'n', '0'},
        };

        int result = sut.solution(N, graph);

        assertThat(result).isEqualTo(134);
    }
}
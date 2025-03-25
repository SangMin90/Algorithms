package ddongman.doit.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ABCDETest {

    private ABCDE sut;

    @BeforeEach
    void setUp() {
        sut = new ABCDE();
    }

    @Test
    void case1() {
        int n = 5;
        int m = 4;
        int[][] relation = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}};

        int result = sut.solution(n, m, relation);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        int n = 5;
        int m = 5;
        int[][] relation = new int[][]{{0, 1},{1, 2},{2, 3},{3, 0},{1, 4}};

        int result = sut.solution(n, m, relation);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int n = 6;
        int m = 5;
        int[][] relation = new int[][]{{0, 1},{0, 2},{0, 3},{0, 4},{0, 5}};

        int result = sut.solution(n, m, relation);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int n = 8;
        int m = 8;
        int[][] relation = new int[][]{{1, 7},{3, 7},{4, 7},{3, 4},{4, 6},{3, 5},{0, 4},{2, 7}};

        int result = sut.solution(n, m, relation);

        assertThat(result).isEqualTo(1);
    }
}
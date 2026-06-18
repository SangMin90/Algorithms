package ddongman.algorithms.leet.graph;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {

    private SnakesAndLadders sut;

    @BeforeEach
    public void setUp() {
        sut = new SnakesAndLadders();
    }

    @Test
    void case1() {
        int[][] board = {
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 35, -1, -1, 13, -1},
            {-1, -1, -1, -1, -1, -1},
            {-1, 15, -1, -1, -1, -1}
        };

//        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        int[][] board = {
            {-1, -1},
            {-1, 3}
        };

//        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int[][] board = {
            {-1, -1, -1},
            {-1, 9, 8},
            {-1, 8, 9}
        };

        //        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        int[][] board = {
            {1, 1, -1},
            {1, 1, 1},
            {-1, 1, 1}
        };

        //        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void case5() {
        int[][] board = {
            {-1, -1, 30, 14, 15, -1},
            {23, 9, -1, -1, -1, 9},
            {12, 5, 7, 24, -1, 30},
            {10, -1, -1, -1, 25, 17},
            {32, -1, 28, -1, -1, 32},
            {-1, -1, 23, -1, 13, 19},
        };

        //        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case6() {
        int[][] board = {
            {-1, 11, 6, -1},
            {-1, 15, 16, -1},
            {-1, 7, -1, 8},
            {-1, -1, -1, 8},
        };

        //        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case7() {
        int[][] board = {
            {-1, 42, 12, -1, 1, -1, -1},
            {-1, -1, 5, -1, -1, 46, 44},
            {18, 22, 6, 39, -1, -1, -1},
            {-1, -1, 40, -1, -1, -1, 37},
            {49, 38, 24, -1, 14, 29, -1},
            {-1, -1, 6, -1, -1, -1, 20},
            {-1, -1, 12, 10, -1, 5, 26},
        };

        //        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case8() {
        int[][] board = {
            {-1, -1, -1, 30, -1, 144, 124, 135, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, 167, 93, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, 77, -1, -1, 90, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 122, -1},
            {-1, -1, -1, 23, -1, -1, -1, -1, -1, 155, -1, -1, -1},
            {-1, -1, 140, 29, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, 115, -1, -1, -1, 109, -1, -1, 5},
            {-1, 57, -1, 99, 121, -1, -1, 132, -1, -1, -1, -1, -1},
            {-1, 48, -1, -1, -1, 68, -1, -1, -1, -1, 31, -1, -1},
            {-1, 163, 147, -1, 77, -1, -1, 114, -1, -1, 80, -1, -1},
            {-1, -1, -1, -1, -1, 57, 28, -1, -1, 129, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, 87, -1, -1, -1}
        };

        //        int result = sut.snakesAndLadders(board);
        int result = sut.snakesAndLaddersWithBfs(board);

        assertThat(result).isEqualTo(6);
    }
}
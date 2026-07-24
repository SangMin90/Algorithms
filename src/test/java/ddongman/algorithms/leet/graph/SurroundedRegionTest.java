package ddongman.algorithms.leet.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SurroundedRegionTest {

    private SurroundedRegion sut;

    @BeforeEach
    void setUp() {
        sut = new SurroundedRegion();
    }

    @Test
    void case1() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}};

//        char[][] result = sut.solve(board);
        char[][] result = sut.solve2(board);

        assertThat(result).isEqualTo(new char[][]{
            {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}
        });
    }
}
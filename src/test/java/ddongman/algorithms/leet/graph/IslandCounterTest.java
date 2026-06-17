package ddongman.algorithms.leet.graph;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IslandCounterTest {

    private IslandCounter sut;

    @BeforeEach
    void setUp() {
        sut = new IslandCounter();
    }

    @Test
    void case1() {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

//        int result = sut.numIslands(grid);
//        int result = sut.numIslands2(grid);
        int result = sut.numIslands3(grid);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        char[][] grid = {
            {'1', '1', '0', '0', '0' },
            {'1', '1', '0', '0', '0' },
            {'0', '0', '1', '0', '0' },
            {'0', '0', '0', '1', '1' }
        };

//        int result = sut.numIslands(grid);
//        int result = sut.numIslands2(grid);
        int result = sut.numIslands3(grid);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        char[][] grid = {
            {'1', '1', '1' },
            {'0', '1', '0' },
            {'1', '1', '1' }
        };

//        int result = sut.numIslands(grid);
//        int result = sut.numIslands2(grid);
        int result = sut.numIslands3(grid);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        char[][] grid = {
            {'1', '0', '1', '1', '1' },
            {'1', '0', '1', '0', '1' },
            {'1', '1', '1', '0', '1' }
        };

//        int result = sut.numIslands(grid);
//        int result = sut.numIslands2(grid);
        int result = sut.numIslands3(grid);

        assertThat(result).isEqualTo(1);
    }
}
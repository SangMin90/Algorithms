package ddongman.doit.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MazeExplorationTest {

    private MazeExploration sut;

    @BeforeEach
    void setUp() {
        sut = new MazeExploration();
    }

    @Test
    void case1() {
        int n = 4;
        int m = 6;
        int[][] maze = new int[][]{
                {1, 0, 1, 1, 1, 1}
                , {1, 0, 1, 0, 1, 0}
                , {1, 0, 1, 0, 1, 1}
                , {1, 1, 1, 0, 1, 1}
        };

        int result = sut.solution(n, m, maze);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void case2() {
        int n = 4;
        int m = 6;
        int[][] maze = new int[][]{
                {1, 1, 0, 1, 1, 0}
                , {1, 1, 0, 1, 1, 0}
                , {1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 0, 1}
        };

        int result = sut.solution(n, m, maze);

        assertThat(result).isEqualTo(9);
    }

    @Test
    void case3() {
        int n = 2;
        int m = 25;
        int[][] maze = new int[][]{
                {1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}
                , {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1}
        };

        int result = sut.solution(n, m, maze);

        assertThat(result).isEqualTo(38);
    }

    @Test
    void case4() {
        int n = 7;
        int m = 7;
        int[][] maze = new int[][]{
                {1, 0, 1, 1, 1, 1, 1}
                , {1, 1, 1, 0, 0, 0, 1}
                , {1, 0, 0, 0, 0, 0, 1}
                , {1, 0, 0, 0, 0, 0, 1}
                , {1, 0, 0, 0, 0, 0, 1}
                , {1, 0, 0, 0, 0, 0, 1}
                , {1, 1, 1, 1, 1, 1, 1}
        };

        int result = sut.solution(n, m, maze);

        assertThat(result).isEqualTo(13);
    }
}
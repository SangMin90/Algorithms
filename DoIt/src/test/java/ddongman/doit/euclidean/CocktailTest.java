package ddongman.doit.euclidean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CocktailTest {

    private Cocktail sut;

    @BeforeEach
    void setUp() {
        sut = new Cocktail();
    }

    @Test
    void case1() {
        int n = 5;
        int[][] arr = new int[][] {
                {4, 0, 1, 1},
                {4, 1, 3, 1},
                {4, 2, 5, 1},
                {4, 3, 7, 1}
        };

        int[] result = sut.solution(n, arr);

        assertThat(result).isEqualTo(new int[] {105, 35, 21, 15, 105});
    }

    @Test
    void case2() {
        int n = 2;
        int[][] arr = new int[][] {
                {0, 1, 6, 4}
        };

        int[] result = sut.solution(n, arr);

        assertThat(result).isEqualTo(new int[] {3, 2});
    }

    @Test
    void case3() {
        int n = 3;
        int[][] arr = new int[][] {
                {0, 1, 9, 8},
                {1, 2, 9, 8}
        };

        int[] result = sut.solution(n, arr);

        assertThat(result).isEqualTo(new int[] {81, 72, 64});
    }

    @Test
    void case4() {
        int n = 4;

        int[][] arr = new int[][] {
                {2, 3, 6, 8},
                {0, 1, 9, 3},
                {3, 0, 7, 5}
        };

        int[] result = sut.solution(n, arr);

        assertThat(result).isEqualTo(new int[] {60, 20, 63, 84});
    }
}
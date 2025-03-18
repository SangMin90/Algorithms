package ddongman.doit.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FinderLinkedComponentTest {

    private FinderLinkedComponent sut;

    @BeforeEach
    void setUp() {
        sut = new FinderLinkedComponent();
    }

    @Test
    void case1() {
        int n = 7;
        int m = 9;
        int[][] arr = new int[][]{{1, 2}, {1, 3}, {2, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 5}, {6, 7}};

        int result = sut.solution(n, m, arr);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        int n = 6;
        int m = 5;
        int[][] arr = new int[][]{{1, 2}, {2, 5}, {5, 1}, {3, 4}, {4, 6}};

        int result = sut.solution(n, m, arr);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int n = 6;
        int m = 8;
        int[][] arr = new int[][]{{1, 2}, {2, 5}, {5, 1}, {3, 4}, {4, 6}, {5, 4}, {2, 4}, {2, 3}};

        int result = sut.solution(n, m, arr);

        assertThat(result).isEqualTo(1);

    }
}
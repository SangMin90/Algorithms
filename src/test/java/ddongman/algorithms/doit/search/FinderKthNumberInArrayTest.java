package ddongman.algorithms.doit.search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class FinderKthNumberInArrayTest {

    private FinderKthNumberInArray sut;

    @BeforeEach
    void setUp() {
        sut = new FinderKthNumberInArray();
    }

    @Test
    void case1() {
        int n = 3;
        int k = 7;

        int result = sut.solution(n, k);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case2() {
        int n = 3;
        int k = 6;

        int result = sut.solution(n, k);

        assertThat(result).isEqualTo(4);
    }
}
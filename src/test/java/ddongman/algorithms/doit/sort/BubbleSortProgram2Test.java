package ddongman.algorithms.doit.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BubbleSortProgram2Test {

    private BubbleSortProgram2 sut;

    @BeforeEach
    void setUp() {
        sut = new BubbleSortProgram2();
    }

    @Test
    void case1() {
        int n = 3;
        int[] numbers = new int[]{3, 2, 1};

        int result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int n = 5;
        int[] numbers = new int[]{5, 1, 4, 3, 2};

        int result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(7);
    }
}
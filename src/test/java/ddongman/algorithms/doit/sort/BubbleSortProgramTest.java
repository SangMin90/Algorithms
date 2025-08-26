package ddongman.algorithms.doit.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BubbleSortProgramTest {

    private BubbleSortProgram sut;

    @BeforeEach
    void setUp() {
        sut = new BubbleSortProgram();
    }

    @Test
    void case1() {
        int n = 5;
        int[] numbers = new int[]{10, 1, 5, 2, 3};

        int result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int n = 5;
        int[] numbers = new int[]{1, 3, 5, 7, 9};

        int result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(1);
    }
}
package ddongman.algorithms.doit.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CountingSortTest {

    private CountingSort sut;

    @BeforeEach
    void setUp() {
        sut = new CountingSort();
    }

    @Test
    void case1() {
        int n = 10;
        int[] numbers = new int[]{5, 2, 3, 1, 4, 2, 3, 5, 1, 7};

        int[] result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 7});
    }

    @Test
    void case2() {
        int n = 6;
        int[] numbers = new int[]{16, 80, 18, 77, 3, 24, 88, 23};

        int[] result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(new int[]{3, 16, 18, 23, 24, 77, 80, 88});
    }

}
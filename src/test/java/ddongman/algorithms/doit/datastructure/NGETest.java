package ddongman.algorithms.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NGETest {

    private NGE sut;

    @BeforeEach
    void setUp() {
        sut = new NGE();
    }

    @Test
    void case1() {
        int n = 4;
        int[] numbers = new int[]{9, 5, 4, 8};

        int[] result = sut.solution(n, numbers);

        Assertions.assertThat(result).isEqualTo(new int[]{-1, 8, 8, -1});
    }

    @Test
    void case2() {
        int n = 4;
        int[] numbers = new int[]{3, 5, 2, 7};

        int[] result = sut.solution(n, numbers);

        Assertions.assertThat(result).isEqualTo(new int[]{5, 7, 7, -1});
    }

}
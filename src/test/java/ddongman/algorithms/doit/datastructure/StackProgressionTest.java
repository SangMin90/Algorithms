package ddongman.algorithms.doit.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StackProgressionTest {

    private StackProgression sut;

    @BeforeEach
    void setUp() {
        this.sut = new StackProgression();
    }

    @Test
    void case1() {
        int n = 8;
        int[] numbers = new int[]{4, 3, 6, 8, 7, 5, 2, 1};

        String result = sut.solution(n, numbers);

        assertThat(result).isEqualTo("++++--++-++-----");
    }

    @Test
    void case2() {
        int n = 5;
        int[] numbers = new int[]{1, 2, 5, 3, 4};

        String result = sut.solution(n, numbers);

        assertThat(result).isEqualTo("NO");
    }
}
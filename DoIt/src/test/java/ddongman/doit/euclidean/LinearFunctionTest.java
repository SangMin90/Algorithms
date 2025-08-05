package ddongman.doit.euclidean;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinearFunctionTest {

    private LinearFunction sut;

    @BeforeEach
    void setUp() {
        sut = new LinearFunction();
    }

    @Test
    void case1() {
        int a = 1;
        int b = 2;
        int c = 3;

        int[] result = sut.solution(a, b, c);

        assertThat(result).isEqualTo(new int[]{3, 0});
    }

    @Test
    void case2() {
        int a = 3;
        int b = 4;
        int c = 5;

        int[] result = sut.solution(a, b, c);

        assertThat(result).isEqualTo(new int[]{-5, 5});
    }

    @Test
    void case3() {
        int a = 6;
        int b = 8;
        int c = 3;

        int[] result = sut.solution(a, b, c);

        assertThat(result).isEqualTo(new int[]{-1});
    }

}
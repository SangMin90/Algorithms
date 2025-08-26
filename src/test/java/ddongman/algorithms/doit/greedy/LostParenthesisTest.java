package ddongman.algorithms.doit.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LostParenthesisTest {

    private LostParenthesis sut;

    @BeforeEach
    void setUp() {
        sut = new LostParenthesis();
    }

    @Test
    void case1() {
        String expression = "55-50+40";

        long result = sut.solution(expression);

        assertThat(result).isEqualTo(-35L);
    }

    @Test
    void case2() {
        String expression = "10+20+30+40";

        long result = sut.solution(expression);

        assertThat(result).isEqualTo(100L);
    }

    @Test
    void case3() {
        String expression = "00009-00009";

        long result = sut.solution(expression);

        assertThat(result).isEqualTo(0L);
    }
}
package ddongman.algorithms.doit.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumTest {

    private Sum sut;

    @BeforeEach
    void setUp() {
        sut = new Sum();
    }

    @Test
    void case1() {
        int n = 1;
        String numbers = "1";

        long result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        int n = 5;
        String numbers = "54321";

        long result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void case3() {
        int n = 25;
        String numbers = "7000000000000000000000000";

        long result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(7);
    }

    @Test
    void case4() {
        int n = 11;
        String numbers = "10987654321";

        long result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(46);
    }
}
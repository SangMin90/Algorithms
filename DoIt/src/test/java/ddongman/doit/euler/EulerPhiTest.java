package ddongman.doit.euler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class EulerPhiTest {

    private EulerPhi sut;

    @BeforeEach
    void setUp() {
        sut = new EulerPhi();
    }

    @Test
    void case1() {
        int n = 1;

        long result = sut.solution(n);

        assertThat(result).isEqualTo(1L);
    }

    @Test
    void case2() {
        int n = 5;

        long result = sut.solution(n);

        assertThat(result).isEqualTo(4L);
    }

    @Test
    void case3() {
        int n = 10;

        long result = sut.solution(n);

        assertThat(result).isEqualTo(4L);
    }

    @Test
    void case4() {
        int n = 45;

        long result = sut.solution(n);

        assertThat(result).isEqualTo(24L);
    }

    @Test
    void case5() {
        int n = 99;

        long result = sut.solution(n);

        assertThat(result).isEqualTo(60L);
    }
}
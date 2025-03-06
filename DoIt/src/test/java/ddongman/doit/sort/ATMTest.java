package ddongman.doit.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ATMTest {

    private ATM sut;

    @BeforeEach
    void setUp() {
        this.sut = new ATM();
    }

    @Test
    void case1() {
        int n = 5;
        int[] numbers = new int[]{3, 1, 4, 3, 2};

        int result = sut.solution(n, numbers);

        Assertions.assertThat(result).isEqualTo(32);
    }
}
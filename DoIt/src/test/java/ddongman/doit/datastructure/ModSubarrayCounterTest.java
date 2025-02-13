package ddongman.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModSubarrayCounterTest {

    private ModSubarrayCounter sut;

    @BeforeEach
    void setUp() {
        sut = new ModSubarrayCounter();
    }

    @Test
    void case1() {
        int n = 5;
        int m = 3;
        int[] numbers = new int[]{1, 2, 3, 1, 2};

        long result = sut.solution(n, m, numbers);

        Assertions.assertThat(result).isEqualTo(7L);
    }
}
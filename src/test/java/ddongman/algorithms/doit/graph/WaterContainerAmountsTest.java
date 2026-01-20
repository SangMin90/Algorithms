package ddongman.algorithms.doit.graph;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WaterContainerAmountsTest {

    private WaterContainerAmounts sut;

    @BeforeEach
    void setUp() {
        sut = new WaterContainerAmounts();
    }

    @Test
    void case1() {
        int a = 8;
        int b = 9;
        int c = 10;

        //when
        int[] result = sut.solution(a, b, c);

        //then
        Assertions.assertThat(result).isEqualTo(new int[]{1, 2, 8, 9, 10});
    }
}
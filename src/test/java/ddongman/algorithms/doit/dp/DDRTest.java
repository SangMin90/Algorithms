package ddongman.algorithms.doit.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class DDRTest {

    private DDR sut;

    @Test
    void case1() {
        int[] directions = new int[]{1, 2, 2, 4};
        sut = new DDR(directions.length);

        int result = sut.play(directions);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void case2() {
        int[] directions = new int[]{1};
        sut = new DDR(directions.length);

        int result = sut.play(directions);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int[] directions = new int[]{1, 2, 1};
        sut = new DDR(directions.length);

        int result = sut.play(directions);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case4() {
        int[] directions = new int[]{1, 2, 1, 2, 1, 2};
        sut = new DDR(directions.length);

        int result = sut.play(directions);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void case5() {
        int[] directions = new int[]{1, 3, 2, 4, 1, 2};
        sut = new DDR(directions.length);

        int result = sut.play(directions);

        assertThat(result).isEqualTo(14);
    }
}
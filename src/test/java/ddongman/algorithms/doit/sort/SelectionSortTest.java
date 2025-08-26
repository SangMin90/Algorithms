package ddongman.algorithms.doit.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortTest {

    private SelectionSort sut;

    @BeforeEach
    void setUp() {
        sut = new SelectionSort();
    }

    @Test
    void case1() {
        String number = "2143";

        String result = sut.solution(number.toCharArray());

        assertThat(result).isEqualTo("4321");
    }

    @Test
    void case2() {
        String number = "999998999";

        String result = sut.solution(number.toCharArray());

        assertThat(result).isEqualTo("999999998");
    }

    @Test
    void case3() {
        String number = "61423";

        String result = sut.solution(number.toCharArray());

        assertThat(result).isEqualTo("64321");
    }

    @Test
    void case4() {
        String number = "500613009";

        String result = sut.solution(number.toCharArray());

        assertThat(result).isEqualTo("965310000");
    }
}
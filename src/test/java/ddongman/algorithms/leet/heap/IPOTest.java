package ddongman.algorithms.leet.heap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IPOTest {

    private IPO sut;

    @BeforeEach
    void setUp() {
        sut = new IPO();
    }

    @Test
    void case1() {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 1};

//        int result = sut.findMaximizedCapital(k, w, profits, capital);
        int result = sut.findMaximizedCapital2(k, w, profits, capital);

        assertThat(result).isEqualTo(4);
    }
    
    @Test
    void case2() {
        int k = 3, w = 0;
        int[] profits = {1, 2, 3}, capital = {0, 1, 2};

//        int result = sut.findMaximizedCapital(k, w, profits, capital);
        int result = sut.findMaximizedCapital2(k, w, profits, capital);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case3() {
        int k = 1, w = 0;
        int[] profits = {1, 2, 3}, capital = {1, 1, 2};

//        int result = sut.findMaximizedCapital(k, w, profits, capital);
        int result = sut.findMaximizedCapital2(k, w, profits, capital);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case4() {
        int k = 3, w = 1;
        int[] profits = {1, 2, 3}, capital = {1, 1, 1};

//        int result = sut.findMaximizedCapital(k, w, profits, capital);
        int result = sut.findMaximizedCapital2(k, w, profits, capital);

        assertThat(result).isEqualTo(7);
    }
}
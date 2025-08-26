package ddongman.algorithms.doit.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardSorterTest {

    private CardSorter sut;

    @BeforeEach
    void setUp() {
        sut = new CardSorter();
    }

    @Test
    void case1() {
        int n = 3;
        int[] cards = new int[]{10, 20, 40};

        long result = sut.solution(n, cards);

        assertThat(result).isEqualTo(100L);
    }

    @Test
    void case2() {
        int n = 3;
        int[] cards = new int[]{10, 20, 40};

        long result = sut.solution2(n, cards);

        assertThat(result).isEqualTo(100L);
    }
}
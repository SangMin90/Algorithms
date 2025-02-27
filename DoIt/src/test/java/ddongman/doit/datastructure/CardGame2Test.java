package ddongman.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardGame2Test {

    private CardGame2 sut;

    @BeforeEach
    void setUp() {
        sut = new CardGame2();
    }

    @Test
    void case1() {
        int n = 6;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        int n = 7;

        int result = sut.solution(n);

        assertThat(result).isEqualTo(6);
    }
}
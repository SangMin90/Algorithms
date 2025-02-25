package ddongman.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinNumberFinderTest {

    private MinNumberFinder sut;

    @BeforeEach
    void setUp() {
        sut = new MinNumberFinder();
    }

    @Test
    void case1() {
        int n = 12;
        int l = 3;
        int[] numbers = new int[]{1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6};

        int[] result = sut.solution(n, l, numbers);

        assertThat(result).isEqualTo(new int[]{1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 2, 2});
    }
}
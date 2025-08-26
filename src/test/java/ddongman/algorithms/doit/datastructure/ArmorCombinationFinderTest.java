package ddongman.algorithms.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ArmorCombinationFinderTest {

    private ArmorCombinationFinder sut;

    @BeforeEach
    void setUp() {
        sut = new ArmorCombinationFinder();
    }

    @Test
    void case1() {
        int n = 6;
        int m = 9;
        int[] numbers = new int[]{2, 7, 4, 1, 5, 3};

        int result = sut.solution(n, m, numbers);

        Assertions.assertThat(result).isEqualTo(2);
    }
}
package ddongman.algorithms.leet.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CombinationsTest {

    private Combinations sut;

    @BeforeEach
    void setUp() {
        sut = new Combinations();
    }

    @Test
    void case1() {
        int n = 4, k = 2;

        List<List<Integer>> result = sut.combine(n, k);

        assertThat(result).containsExactlyInAnyOrder(
            List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3), List.of(2, 4),
            List.of(3, 4));
    }

    @Test
    void case2() {
        int n = 1, k = 1;

        List<List<Integer>> result = sut.combine(n, k);

        assertThat(result).containsExactlyInAnyOrder(List.of(1));
    }
}
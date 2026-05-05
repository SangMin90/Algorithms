package ddongman.algorithms.leet.bit;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubsetFinderTest {

    private SubsetFinder sut;

    @Test
    void case1() {
        int[] nums = new int[]{1, 2, 3};
        sut = new SubsetFinder();

        List<List<Integer>> result = sut.subsets(nums);

        assertThat(result).isEqualTo(
                List.of(
                        Collections.emptyList(),
                        List.of(1),
                        List.of(2),
                        List.of(1, 2),
                        List.of(3),
                        List.of(1, 3),
                        List.of(2, 3),
                        List.of(1, 2, 3)
                )
        );
    }

    @Test
    void case2() {
        int[] nums = new int[]{0};
        sut = new SubsetFinder();

        List<List<Integer>> result = sut.subsets(nums);

        assertThat(result).isEqualTo(
                List.of(
                        Collections.emptyList(),
                        List.of(0)
                )
        );
    }
}
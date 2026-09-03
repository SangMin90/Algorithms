package ddongman.algorithms.leet.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class PermutationsTest {

    private Permutations sut;

    @Test
    void case1() {
        int[] nums = {1,2,3};
        sut = new Permutations();

//        List<List<Integer>> result = sut.permute(nums);
        List<List<Integer>> result = sut.permute2(nums);

        assertThat(result).containsExactlyInAnyOrder(
            List.of(1,2,3),List.of(1,3,2),List.of(2,1,3),List.of(2,3,1),List.of(3,1,2),List.of(3,2,1)
        );
    }

    @Test
    void case2() {
        int[] nums = {0,1};
        sut = new Permutations();

//        List<List<Integer>> result = sut.permute(nums);
        List<List<Integer>> result = sut.permute2(nums);

        assertThat(result).containsExactlyInAnyOrder(
            List.of(0, 1), List.of(1, 0)
        );
    }

    @Test
    void case3() {
        int[] nums = {1};
        sut = new Permutations();

//        List<List<Integer>> result = sut.permute(nums);
        List<List<Integer>> result = sut.permute2(nums);

        assertThat(result).containsExactlyInAnyOrder(List.of(1));
    }
}
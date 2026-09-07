package ddongman.algorithms.leet.heap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class KPairsWithSmallestSumFinderTest {

    private KPairsWithSmallestSumFinder sut;

    @Test
    void case1() {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        sut = new KPairsWithSmallestSumFinder();

//        List<List<Integer>> result = sut.kSmallestPairs(nums1, nums2, k);
//        List<List<Integer>> result = sut.kSmallestPairs2(nums1, nums2, k);
        List<List<Integer>> result = sut.kSmallestPairs3(nums1, nums2, k);

        assertThat(result).containsExactlyInAnyOrder(List.of(1,2),List.of(1,4),List.of(1,6));
    }

    @Test
    void case2() {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        int k = 2;
        sut = new KPairsWithSmallestSumFinder();

//        List<List<Integer>> result = sut.kSmallestPairs(nums1, nums2, k);
//        List<List<Integer>> result = sut.kSmallestPairs2(nums1, nums2, k);
        List<List<Integer>> result = sut.kSmallestPairs3(nums1, nums2, k);

        assertThat(result).containsExactlyInAnyOrder(List.of(1,1),List.of(1,1));
    }
}
package ddongman.algorithms.leet.bit;

import java.util.ArrayList;
import java.util.List;

public class SubsetFinder {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> powerSet = new ArrayList<>();

        int N = nums.length;
        for (int i = 0; i < 1 << N; i++) {

            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            powerSet.add(subset);
        }

        return powerSet;
    }
}

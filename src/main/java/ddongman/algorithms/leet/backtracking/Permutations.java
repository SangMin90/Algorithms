package ddongman.algorithms.leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    private int N;
    private boolean[] visited;
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        N = nums.length;
        visited = new boolean[N];

        backtracking(nums, new ArrayList<>());

        return result;
    }

    private void backtracking(int[] nums, List<Integer> path) {

        if (path.size() >= N) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int index = 0; index < N; index++) {
            if (!visited[index]) {
                visited[index] = true;
                path.add(nums[index]);
                backtracking(nums, path);
                path.removeLast();
                visited[index] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtracking2(0, nums, result);

        return result;
    }

    private void backtracking2(int index, int[] nums, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> comb = new ArrayList<>();
            for (int i = 0; i < index; i++) {
                comb.add(nums[i]);
            }

            result.add(comb);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            backtracking2(index + 1, nums, result);
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}

package ddongman.doit.search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntegerFinder {
    public int[] solution(int n, int[] nums, int k, int[] targetNums) {
        Arrays.sort(nums);
        return IntStream.range(0, k)
                .map(i -> binarySearch(nums, targetNums[i], 0, n - 1))
                .toArray();
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return 0;
    }
}

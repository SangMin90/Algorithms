package ddongman.algorithms.leet.slidingWindow;

public class MinimumSubarraySumFinder {

    public int minSubArrayLen(int target, int[] nums) {

        int start = 0;
        int end = 0;

        int size = nums.length + 1;
        int sum = nums[start];

        while (start <= end) {
            if (target <= sum) {
                size = Math.min(size, end - start + 1);
                sum -= nums[start];
                start++;
            } else {
                end++;

                if (end == nums.length) {
                    break;
                }

                sum += nums[end];
            }
        }

        if (size == nums.length + 1) {
            return 0;
        }

        return size;
    }
}

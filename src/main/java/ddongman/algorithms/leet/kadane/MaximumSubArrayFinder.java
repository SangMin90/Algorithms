package ddongman.algorithms.leet.kadane;

public class MaximumSubArrayFinder {

    public int maxSubArray(int[] nums) {

        int currSum = 0;
        int bestSum = Integer.MIN_VALUE;

        for (int num : nums) {
            currSum = Math.max(num, currSum + num);
            bestSum = Math.max(bestSum, currSum);
        }

        return bestSum;
    }

    public int maxSubArray2(int[] nums) {

        return divideNConquer(nums, 0, nums.length - 1);
    }

    private int divideNConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        int leftMax = divideNConquer(nums, left, mid);
        int rightMax = divideNConquer(nums, mid + 1, right);
        int crossMax = calculateCrossMax(nums, left, mid, right);

        return Math.max(crossMax, Math.max(leftMax, rightMax));
    }

    private int calculateCrossMax(int[] nums, int left, int mid, int right) {

        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftMax = Math.max(leftMax, sum);
        }

        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightMax = Math.max(rightMax, sum);
        }

        return leftMax + rightMax;
    }
}

package ddongman.algorithms.leet.kadane;

public class MaximumSumCircularArray {

    public int maxSubarraySumCircular(int[] nums) {

        int currMax = 0;
        int currMin = 0;

        int total = 0;
        int max = -30_001;
        int min = 30_001;

        for (int num : nums) {
            total += num;
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
        }

        return max < 0 ? max : Math.max(max, (total - min));
    }
}

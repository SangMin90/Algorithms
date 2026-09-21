package ddongman.algorithms.leet.contest.weekly520;

public class MaximumPulseCalculator {

    public long maxValue(int[] nums) {

        int n = nums.length;
        long[] P = new long[n + 1];

        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                P[i + 1] = P[i] + nums[i];
            } else {
                P[i + 1] = P[i] - nums[i];
            }
        }

        long kadane = 0;
        for (int i = 0; i <= 1; i++) {
            int sign = 1 - (i << 1);
            long curr = 0;
            for (int j = i; j < n - 1; j += 2) {
                long diff = ((long) nums[j + 1] - nums[j]) * sign;
                curr = Math.max(diff, curr + diff);
                kadane = Math.max(kadane, 2 * curr);
            }
        }

        return Math.max(kadane + P[n], P[n]);
    }
}

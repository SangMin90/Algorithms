package ddongman.algorithms.leet.dp;

import java.util.Arrays;

public class HouseRobber {

    private int[] dp;

    public int rob(int[] nums) {

        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        return Math.max(dp(n - 1, nums), dp(n - 2, nums));
    }

    private int dp(int i, int[] nums) {

        if (i < 0) {
            return 0;
        }

        if (dp[i] >= 0) {
            return dp[i];
        }

        return dp[i] = Math.max(dp(i - 2, nums), dp(i - 3, nums)) + nums[i];
    }

}

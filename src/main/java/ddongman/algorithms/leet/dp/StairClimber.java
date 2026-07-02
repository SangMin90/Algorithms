package ddongman.algorithms.leet.dp;

public class StairClimber {

    private int[] dp;

    public int climbStairs(int n) {
        dp = new int[n + 1];

        return climb(n);
    }

    private int climb(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = climb(n - 1) + climb(n - 2);
    }
}

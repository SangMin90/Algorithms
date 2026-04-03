package ddongman.algorithms.doit.dp;

public class TwoByNTiling {

    private final int[] dp;

    public TwoByNTiling(int maxN) {
        dp = new int[maxN + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= maxN; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
    }

    public int countTilingWaysTwoBy(int n) {
        return dp[n];
    }
}

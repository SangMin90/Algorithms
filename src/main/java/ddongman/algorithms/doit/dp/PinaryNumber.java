package ddongman.algorithms.doit.dp;

public class PinaryNumber {

    private long[] dp;

    public PinaryNumber(int maxN) {
        dp = new long[maxN + 1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= maxN; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public long count(int N) {
        return dp[N];
    }
}

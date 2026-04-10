package ddongman.algorithms.doit.dp;

public class BuildingOrderCalculator {

    private static final int divisor = 1_000_000_007;

    private final int[][][] dp;

    public BuildingOrderCalculator(int N) {
        dp = new int[N + 1][N + 1][N + 1];

        dp[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                for (int k = 1; k <= i; k++) {
                    dp[i][j][k] = (int) (
                            (
                                    (long)(dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]) +
                                    ((long) (i - 2) * dp[i - 1][j][k])
                            ) % divisor
                    );
                }
            }
        }
    }

    public int count(int N, int L, int R) {
        return dp[N][L][R];
    }
}

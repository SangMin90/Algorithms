package ddongman.algorithms.doit.dp;

public class StepNumber {

    private final int divisor = 1_000_000_000;
    private int[][] dp;

    public StepNumber(int maxN) {
        dp = new int[maxN + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= maxN; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] += ((j - 1 >= 0 ? dp[i - 1][j - 1] : 0)
                        + (j + 1 <= 9 ? dp[i - 1][j + 1] : 0)) % divisor;
            }
        }
    }

    public long countOf(int N) {

        long sum = 0;
        for (int way : dp[N]) {
            sum += way;
        }

        return sum % divisor;
    }
}

package ddongman.algorithms.doit.dp;

public class OneMaker {

    private final int[] dp;

    public OneMaker(int maxN) {

        dp = new int[maxN + 1];

        for (int curr = 2; curr <= maxN; curr++) {

            dp[curr] = dp[curr - 1] + 1;

            if (curr % 3 == 0) {
                dp[curr] = Math.min(dp[curr], dp[curr / 3] + 1);
            }

            if (curr % 2 == 0) {
                dp[curr] = Math.min(dp[curr], dp[curr / 2] + 1);
            }
        }
    }

    public int countMakingOneOf(int N) {
        return dp[N];
    }
}

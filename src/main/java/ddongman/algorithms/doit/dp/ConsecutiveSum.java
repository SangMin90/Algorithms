package ddongman.algorithms.doit.dp;

import java.util.Arrays;

public class ConsecutiveSum {

    private final int MIN = -100_000_000;
    private final int N;
    private final int[][] dp;

    public ConsecutiveSum(int N) {
        this.N = N;
        dp = new int[N + 1][2];
        dp[0][0] = MIN;
        dp[0][1] = MIN;
    }

    public int max(int[] elements) {

        if (N == 1) {
            return elements[N - 1];
        }

        for (int i = 1; i <= N; i++) {
            int num = elements[i - 1];
            dp[i][0] = Math.max(num, dp[i - 1][0] + num);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + num);
        }

        return Arrays.stream(dp)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElseThrow(() -> new RuntimeException("최댓값이 존재하지 않습니다."));
    }
}

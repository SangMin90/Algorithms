package ddongman.algorithms.doit.dp;

import java.util.Arrays;

public class TSP {

    private static int INF = 16_000_001;

    private final int N;
    private final int[][] dp;
    private final int[][] weights;

    public TSP(int N, int[][] weights) {
        this.N = N;
        dp = new int[N][1 << N];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        this.weights = weights;
    }

    public int tsp(int curr, int visited) {

        if (visited == (1 << N) - 1) {

            if (weights[curr][0] == 0) {
                return INF;
            }

            return weights[curr][0];
        }

        if (dp[curr][visited] != -1) {
            return dp[curr][visited];
        }

        dp[curr][visited] = INF;

        for (int i = 0; i < N; i++) {

            if ((visited & (1 << i)) == 0 && weights[curr][i] != 0) {
                dp[curr][visited] =
                        Math.min(
                                dp[curr][visited],
                                tsp(i, visited | (1 << i)) +
                                        weights[curr][i]
                        );
            }
        }

        return dp[curr][visited];
    }
}

package ddongman.algorithms.doit.dp;

public class RectangularFinder {

    private int maxLen = 0;

    public RectangularFinder(int N, int M, int[][] points) {

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (points[i][j] == 1) {
                    int x = i + 1;
                    int y = j + 1;

                    dp[x][y] = Math.min(
                            Math.min(dp[x - 1][y - 1], dp[x - 1][y]),
                            dp[x][y - 1]) + 1;

                    maxLen = Math.max(maxLen, dp[x][y]);
                }
            }
        }
    }

    public int maxArea() {
        return maxLen * maxLen;
    }
}

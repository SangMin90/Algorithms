package ddongman.algorithms.doit.dp;


public class LCS {

    private final int[][] dp;
    private final char[] X;
    private final char[] Y;

    public LCS(String X, String Y) {
        this.dp = new int[X.length() + 1][Y.length() + 1];
        this.X = X.toCharArray();
        this.Y = Y.toCharArray();
    }

    public int length() {

        int xLen = X.length;
        int yLen = Y.length;

        for (int i = 1; i <= xLen; i++) {
            for (int j = 1; j <= yLen; j++) {

                if (X[i - 1] == Y[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }

                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[xLen][yLen];
    }

    public String lcs() {
        return backTracking(X.length, Y.length);
    }

    private String backTracking(int i, int j) {
        if (i == 0 || j == 0) {
            return "";
        }

        if (X[i - 1] == Y[j - 1]) {
            return backTracking(i - 1, j - 1) + X[i - 1];
        }

        if (dp[i - 1][j] > dp[i][j - 1]) {
            return backTracking(i - 1, j);
        }

        return backTracking(i, j - 1);
    }
}

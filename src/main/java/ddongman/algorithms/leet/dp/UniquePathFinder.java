package ddongman.algorithms.leet.dp;

import java.util.Arrays;

public class UniquePathFinder {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return countPaths(n - 1, m - 1, dp, obstacleGrid);
    }

    private int countPaths(int row, int col, int[][] dp, int[][] obstacleGrid) {

        if (row < 0 || col < 0) {
            return 0;
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row == 0 && col == 0) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        return dp[row][col] = countPaths(row - 1, col, dp, obstacleGrid) + countPaths(row, col - 1, dp, obstacleGrid);
    }
}
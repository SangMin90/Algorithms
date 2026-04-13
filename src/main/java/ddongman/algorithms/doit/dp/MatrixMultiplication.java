package ddongman.algorithms.doit.dp;

import java.util.Arrays;

public class MatrixMultiplication {

    private static final int max = Integer.MAX_VALUE;

    private final int N;
    private final Matrix[] matrix;
    private final int[][] dp;

    public MatrixMultiplication(int[][] size) {
        N = size.length;
        matrix = new Matrix[N];
        for (int i = 0; i < N; i++) {
            int a = size[i][0];
            int b = size[i][1];
            matrix[i] = new Matrix(a, b);
        }
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], max);
            dp[i][i] = 0;
        }
    }

    public int min(int start, int end) {

        if (dp[start][end] != max) {
            return dp[start][end];
        }

        if (end - start == 1) {
            return dp[start][end] = matrix[start].getA() * matrix[end].getA() * matrix[end].getB();
        }

        for (int k = start; k < end; k++) {
            dp[start][end] = Math.min(
                    dp[start][end],
                    min(start, k) +
                            min(k + 1, end) +
                            matrix[start].getA() *
                                    matrix[k + 1].getA() *
                                    matrix[end].getB()
            );
        }

        return dp[start][end];
    }

    static class Matrix {

        private final int a;
        private final int b;

        public Matrix(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
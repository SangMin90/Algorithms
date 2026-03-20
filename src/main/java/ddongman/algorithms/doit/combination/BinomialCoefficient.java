package ddongman.algorithms.doit.combination;

import java.util.function.IntBinaryOperator;

public class BinomialCoefficient {

    private final int[][] comb;

    public BinomialCoefficient(int N) {
        comb = new int[N + 1][N + 1];
        comb[0][0] = 1;
    }

    public int combination(int N, int K) {

        return nCk(N, K, (a, b) -> a + b);
    }

    public int combinationMod(int N, int K, int mod) {

        return nCk(N, K, (a, b) -> (a + b) % mod);
    }

    private int nCk(int N, int K, IntBinaryOperator op) {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] = op.applyAsInt(comb[i - 1][j - 1], comb[i - 1][j]);
                }
            }
        }

        return comb[N][K];
    }
}

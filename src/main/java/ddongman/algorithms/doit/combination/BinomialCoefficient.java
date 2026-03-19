package ddongman.algorithms.doit.combination;

public class BinomialCoefficient {

    private final int[][] comb;

    public BinomialCoefficient(int N) {
        comb = new int[N + 1][N + 1];
        comb[0][0] = 1;
    }

    public int combination(int N, int K) {

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                }
            }
        }

        return comb[N][K];
    }
}

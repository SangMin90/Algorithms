package ddongman.algorithms.doit.combination;

public class BridgeBuilder {

    private final BinomialCoefficient bc;

    public BridgeBuilder(int maxN) {
        this.bc = new BinomialCoefficient(maxN);
    }

    public int countBridgeWays(int N, int M) {
        return bc.combination(M, N);
    }

    static class BinomialCoefficient {

        private final int[][] comb;

        public BinomialCoefficient(int maxN) {
            comb = new int[maxN + 1][maxN + 1];

            for (int i = 0; i <= maxN; i++) {
                comb[i][0] = 1;
                comb[i][i] = 1;
            }

            for (int i = 1; i < maxN; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                    comb[i][i - j] = comb[i][j];
                }
            }
        }

        public int combination(int N, int R) {
            return comb[N][R];
        }
    }
}

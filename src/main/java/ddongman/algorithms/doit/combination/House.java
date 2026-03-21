package ddongman.algorithms.doit.combination;

public class House {

    private final BinomialCoefficient bc;

    public House(int N) {
        this.bc = new BinomialCoefficient(N);
    }

    public long countHouseHolds(int K, int N) {
        return bc.combination(K + N, N - 1);
    }

    static class BinomialCoefficient {

        private final long[][] comb;

        public BinomialCoefficient(int N) {
            comb = new long[N + 1][N + 1];

            for (int i = 0; i < N + 1; i++) {
                comb[i][0] = 1;
                comb[i][i] = 1;
            }

            for (int i = 2; i < N + 1; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
                    comb[i][i - j] = comb[i][j];
                }
            }
        }

        public long combination(int n, int k) {

            return comb[n][k];
        }
    }
}

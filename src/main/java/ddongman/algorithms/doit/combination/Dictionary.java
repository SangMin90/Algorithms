package ddongman.algorithms.doit.combination;

public class Dictionary {

    private final int N;
    private final int M;

    private final BinomialCoefficient bc;

    public Dictionary(int N, int M) {
        this.N = N;
        this.M = M;

        this.bc = new BinomialCoefficient(N + M);
    }

    public String findKthWord(int K) {

        if (K > bc.combination(N + M, N)) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();

        int remainedA = N;
        int remainedZ = M;

        while (remainedA > 0) {

            int caseCount = bc.combination(remainedA + remainedZ - 1, remainedA - 1);
            char c = findChar(remainedA, remainedZ, K, caseCount);

            if ('a' == c) {
                remainedA--;
            }

            if ('z' == c) {
                remainedZ--;
                K -= caseCount;
            }

            sb.append(c);
        }

        while (remainedZ-- > 0) {
            sb.append('z');
        }


        return sb.toString();
    }

    private char findChar(int remainedA, int remainedZ, int K, int caseCount) {

        if (remainedA == 0) {
            return 'z';
        }

        if (remainedZ == 0) {
            return 'a';
        }

        if (K > caseCount) {
            return 'z';
        }

        return 'a';
    }

    static class BinomialCoefficient {

        private final int[][] comb;

        public BinomialCoefficient(int maxN) {

            comb = new int[maxN + 1][maxN + 1];

            for (int i = 0; i < comb.length; i++) {
                comb[i][0] = 1;
                comb[i][i] = 1;
            }

            for (int i = 1; i < comb.length; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    comb[i][j] = Math.min(
                            1_000_000_001,
                            comb[i - 1][j - 1] + comb[i - 1][j]
                    );
                    comb[i][i - j] = comb[i][j];
                }
            }
        }

        public int combination(int N, int R) {
            return comb[N][R];
        }
    }
}

package ddongman.algorithms.doit.combination;

public class Derangement {

    private final long[] D;

    public Derangement(int maxN) {

        D = new long[maxN + 1];
        D[1] = 0;
        D[2] = 1;

        for (int K = 3; K <= maxN; K++) {
            D[K] = ((K - 1) * (D[K - 1] + D[K - 2])) % 1_000_000_000;
        }
    }

    public long count(int N) {
        return D[N];
    }
}

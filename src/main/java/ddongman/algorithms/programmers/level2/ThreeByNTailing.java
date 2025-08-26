package ddongman.algorithms.programmers.level2;

public class ThreeByNTailing {
    public static void main(String[] args) {
        ThreeByNTailing sample = new ThreeByNTailing();
        System.out.println(sample.solution(7));
    }

    public long solution(int n) {
        if (n % 2 == 1) {
            return 0;
        }

        long[] d = new long[n + 1];
        d[0] = 1;
        d[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            d[i] = d[i - 2] * 3;
            for (int j = 4; j <= i; j += 2) {
                d[i] += d[i - j] * 2;
            }
            d[i] %= 1000000007;
        }
        return d[n];
    }
}

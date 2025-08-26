package ddongman.algorithms.programmers.level2;

public class TwoByNTailing {
    public static void main(String[] args) {
        TwoByNTailing sample = new TwoByNTailing();
        System.out.println(sample.solution(4));
    }
    public int solution(int n) {
        d = new int[n + 1];

        return go(n);
    }

    int[] d;

    public int go(int i) {
        if (i == 1) {
            return 1;
        }

        if (i == 2) {
            return 2;
        }

        if (d[i] > 0) {
            return d[i];
        }

        return d[i] = (go(i - 1) + go(i - 2)) % 1000000007;
    }
}

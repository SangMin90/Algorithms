package ddongman.algorithms.programmers.level2;

public class LongJump {
    public static void main(String[] args) {
        LongJump sample = new LongJump();
        System.out.println(sample.solution(2000));
    }
    long[] d;
    public long solution(int n) {
        d = new long[n+1];
        return go(n);
    }
    public long go(int i) {
        if (i == 1) {
            return 1;
        }

        if (i == 2) {
            return 2;
        }

        if (d[i] > 0) {
            return d[i];
        }

        return d[i] = (go(i - 1) + go(i - 2)) % 1234567;
    }
}

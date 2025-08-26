package ddongman.algorithms.programmers.level2;

public class JumpAndTeleport {
    public static void main(String[] args) {
        JumpAndTeleport sample = new JumpAndTeleport();
        System.out.println(sample.solution(1000000000));
    }

    public int solution(int n) {
        return minimumBatteryUse(n);
    }

    int minimumBatteryUse(int n) {
        int cnt = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n - 1);
                cnt++;
            }
        }
        return cnt;
    }
}

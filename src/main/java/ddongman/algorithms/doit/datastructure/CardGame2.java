package ddongman.algorithms.doit.datastructure;

public class CardGame2 {
    public int solution(int n) {
        int lowerPowerOf2 = powerOf2lowerThan(n);
        if (n % lowerPowerOf2 == 0) {
            return n;
        } else {
            return 2 * (n - lowerPowerOf2);
        }
    }

    private int powerOf2lowerThan(int n) {
        int result = 1;
        while (n > 1) {
            n /= 2;
            result *= 2;
        }

        return result;
    }
}

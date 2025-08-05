package ddongman.doit.euclidean;

import java.util.stream.IntStream;

public class LinearFunction {
    public int[] solution(int a, int b, int c) {
        return findLinearCoefficients(a, b, c);
    }

    private int[] findLinearCoefficients(int a, int b, int c) {
        int absA = Math.abs(a);
        int absB = Math.abs(b);
        int absC = Math.abs(c);

        if (absC % a == 0) {
            return new int[]{c / a, 0};
        }

        if (absC % b == 0) {
            return new int[]{0, c / b};
        }

        int n = findNBetween(absA, absB, absC);

        return n == - 1 ? new int[]{-1} : new int[]{-1 * (n - 1) * c / a, n * c / b};
    }

    private int findNBetween(int a, int b, int c) {
        return IntStream.rangeClosed(0, 10000000 / c)
                .filter(i -> (i - 1) % a == 0 && i % b == 0)
                .findFirst()
                .orElse(-1);
    }
}

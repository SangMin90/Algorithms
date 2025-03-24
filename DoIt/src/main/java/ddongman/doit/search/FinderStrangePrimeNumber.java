package ddongman.doit.search;

import java.util.ArrayList;
import java.util.List;

public class FinderStrangePrimeNumber {

    private long limit;
    private final List<Long> strangePrimeNumbers = new ArrayList<>();
    private int maxDigit;

    public long[] solutionV1(int n) {
        limit = power(10, n);

        for (int i = 2; i < 10; i++) {
            dfsV1(i);
        }

        return strangePrimeNumbers.stream().mapToLong(l -> l).toArray();
    }

    public long[] solutionV2(int n) {
        maxDigit = n;

        dfsV2(2, 1);
        dfsV2(3, 1);
        dfsV2(5, 1);
        dfsV2(7, 1);

        return strangePrimeNumbers.stream().mapToLong(l -> l).toArray();
    }

    private void dfsV2(long num, int digit) {
        if (digit == maxDigit) {
            if (isPrime(num)) {
                strangePrimeNumbers.add(num);
            }

            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (i % 2 == 0) {
                continue;
            }

            if (isPrime((num * 10) + i)) {
                dfsV2((num * 10) + i, digit + 1);
            }
        }
    }

    private void dfsV1(long num) {
        if (num >= limit) {
            return;
        }

        if (!isPrime(num)) {
            return;
        }

        if (isStrangeNum(num)) {
            strangePrimeNumbers.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            dfsV1(num * 10 + i);
        }
    }

    private boolean isPrime(long num) {
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private long power(long base, long exponent) {
        long result = 1;
        while (exponent-- > 0) {
            result *= base;
        }

        return result;
    }

    private boolean isStrangeNum(long num) {
        return num < limit && num >= (limit / 10);
    }
}

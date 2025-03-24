package ddongman.doit.search;

import java.util.ArrayList;
import java.util.List;

public class FinderStrangePrimeNumber {

    private long limit;
    private final List<Long> strangePrimeNumbers = new ArrayList<>();

    public long[] solution(int n) {
        limit = power(10, n);

        for (int i = 2; i < 10; i++) {
            dfs(i);
        }

        return strangePrimeNumbers.stream().mapToLong(l -> l).toArray();
    }

    private void dfs(long num) {
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
            dfs(num * 10 + i);
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

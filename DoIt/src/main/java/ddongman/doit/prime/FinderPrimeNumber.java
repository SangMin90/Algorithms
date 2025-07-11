package ddongman.doit.prime;

import java.util.stream.IntStream;

public class FinderPrimeNumber {
    public int[] solution(int m, int n) {
        if (m > n) {
            throw new IllegalArgumentException(m + "이 " + n + "보다 큽니다.");
        }

        return findPrimeNumberBetween(m, n);
    }

    private int[] findPrimeNumberBetween(int m, int n) {
        return IntStream.rangeClosed(m, n)
                .filter(i -> isPrime(i))
                .toArray();
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

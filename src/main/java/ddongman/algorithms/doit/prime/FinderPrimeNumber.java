package ddongman.algorithms.doit.prime;

import java.util.stream.IntStream;

public class FinderPrimeNumber {
    private boolean[] sieve;
    public int[] solution(int m, int n) {
        if (m > n) {
            throw new IllegalArgumentException(m + "이 " + n + "보다 큽니다.");
        }

        return findPrimeNumberBetween(m, n);
    }

    public int[] solution2(int m, int n) {
        if (m > n) {
            throw new IllegalArgumentException(m + "이 " + n + "보다 큽니다.");
        }

        init(n);

        return findPrimeNumberInSieveBetween(m, n);
    }

    private void init(int n) {
        sieve = new boolean[n + 1];

        for (int i = 0; i < sieve.length; i++) {
            if (i == 0 || i == 1) {
                sieve[i] = true;
                continue;
            }

            if (sieve[i]) {
                continue;
            }

            if (isPrime(i)) {
                int multiple = i;
                while ((multiple += i) <= sieve.length - 1) {
                    sieve[multiple] = true;
                }
            }
        }
    }

    private int[] findPrimeNumberBetween(int m, int n) {
        return IntStream.rangeClosed(m, n)
                .filter(this::isPrime)
                .toArray();
    }

    private int[] findPrimeNumberInSieveBetween(int m, int n) {
        return IntStream.rangeClosed(m, n)
                .filter(index -> !sieve[index])
                .toArray();
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}

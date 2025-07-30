package ddongman.doit.prime;

import java.util.stream.LongStream;

public class FindNearlyPrimeNumber {

    private int[] sieve;

    public long solution(long a, long b) {
        init();

        return findNearlyPrimeNumber(a, b).length;
    }

    private long[] findNearlyPrimeNumber(long a, long b) {
        return LongStream.range(0, sieve.length)
                .filter(i -> sieve[(int) i] == 1 && (i >= a && i <= b))
                .toArray();
    }

    private void init() {
        sieve = new int[10000001];

        for (int i = 0; i < sieve.length; i++) {
            if (sieve[i] == 1) {
                continue;
            }

            if (isPrime(i)) {
                long multiple = i;
                while ((multiple *= i) <= sieve.length - 1) {
                    sieve[(int) multiple] = 1;
                }
            }
        }
    }

    private boolean isPrime(int num) {
        if (num == 1 || num == 0) {
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

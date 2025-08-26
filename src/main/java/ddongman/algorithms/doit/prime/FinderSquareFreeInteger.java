package ddongman.algorithms.doit.prime;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FinderSquareFreeInteger {
    private int[] sieve;
    private List<Long> primeNums;
    public long solution(long m, long n) {
        init();

        return findSquareFreeIntegerInRange(m, n);
    }

    private void init() {
        sieve = new int[316230];

        for (int i = 0; i < sieve.length; i++) {
            if (i == 0 || i == 1) {
                sieve[i] = 1;
                continue;
            }

            if (sieve[i] == 1) {
                continue;
            }

            // 소수 판단
            if (isPrime(i)) {

                // 소수가 아닌 배수 제외
                int multiple = i;
                while ((multiple += i) <= sieve.length - 1) {
                    sieve[multiple] = 1;
                }
            }
        }

        primeNums = IntStream
                .range(0, sieve.length)
                .filter(index -> sieve[index] == 0)
                .mapToLong(i -> i)
                .boxed()
                .toList();
    }

    private boolean isPrime(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("수는 1보다 크거나 같고 316230보다 작거나 같습니다.");
        }

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

    private long findSquareFreeIntegerInRange(long m, long n) {

        return LongStream.rangeClosed(m, n)
                .filter(this::isSquareFree)
                .count();
    }

    private boolean isSquareFree(long num) {
        return primeNums.stream()
                .noneMatch(prime -> num % (prime * prime) == 0);
    }
}

package ddongman.doit.euler;

import java.util.List;
import java.util.stream.IntStream;

public class EulerPhi {
    public long solution(int n) {
        List<Long> primeNums = findPrimeNums(n);
        List<Long> factors = findFactors(n, primeNums);
        return calc(n, factors);
    }

    private long calc(int n, List<Long> factors) {
        long result = (long) n;
        for (long factor : factors) {
            result *= (factor - 1);
            result /= factor;
        }

        return result;
    }

    private int[] findSieveOfEratosthenes(int n) {
        int[] sieve = new int[n + 1];

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

        return sieve;
    }

    private List<Long> findPrimeNums(int n) {
        int[] sieve = findSieveOfEratosthenes(n);

        return IntStream
                .rangeClosed(0, n)
                .filter(index -> sieve[index] == 0)
                .mapToLong(i -> i)
                .boxed()
                .toList();
    }

    private boolean isPrime(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("수는 1보다 크거나 같고 1000000보다 작거나 같습니다.");
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

    private List<Long> findFactors(int n, List<Long> primes) {
        return primes
                .stream()
                .filter(prime -> prime <= n && n % prime == 0)
                .toList();
    }
}

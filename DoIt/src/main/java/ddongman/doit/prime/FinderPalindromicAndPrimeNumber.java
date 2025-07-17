package ddongman.doit.prime;

import java.util.NoSuchElementException;

public class FinderPalindromicAndPrimeNumber {
    private boolean[] sieve;

    public int solution(int n) {
        init();

        return findMinimumPalindromic(n);
    }

    private void init() {
        sieve = new boolean[1000001];

        for (int i = 0; i < sieve.length; i++) {
            if (i == 0 || i == 1) {
                sieve[i] = true;
                continue;
            }

            if (sieve[i]) {
                continue;
            }

            // 소수 판단
            if (isPrime(i)) {

                // 소수가 아닌 배수 제외
                int multiple = i;
                while ((multiple += i) <= sieve.length - 1) {
                    sieve[multiple] = true;
                }


                if (!isPalindromic(i)) {
                    sieve[i] = true;
                }
            }
        }
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

    private boolean isPalindromic(int num) {
        if (num < 10) {
            return true;
        }

        if (num < 100) {
            return num % 11 == 0;
        }

        String str = String.valueOf(num);
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    private int findMinimumPalindromic(int num) {
        for (int i = num; i < sieve.length; i++) {
            if (!sieve[i]) {
                return i;
            }
        }

        throw new NoSuchElementException("펠린드롬 수가 존재하지 않습니다.");
    }
}

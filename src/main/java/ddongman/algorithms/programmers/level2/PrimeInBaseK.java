package ddongman.algorithms.programmers.level2;

public class PrimeInBaseK {
    public static void main(String[] args) {
        PrimeInBaseK sample = new PrimeInBaseK();
        System.out.println(sample.solution(56506, 3));
    }
    public int solution(int n, int k) {
        String s = Long.toString(n, k);
        String[] numbers = s.split("0+");

        int count = 0;
        for (String number : numbers) {
            long num = Long.parseLong(number);
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.print(" "+i);
                return false;
            }
        }

        return true;
    }
}

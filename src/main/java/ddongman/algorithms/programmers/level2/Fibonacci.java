package ddongman.algorithms.programmers.level2;

public class Fibonacci {
    public int solution(int n) {
        fibonacci = new int[n+1];
        return getFibonacciNumber(n);
    }
    int[] fibonacci;
    public int getFibonacciNumber(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (fibonacci[i] > 0) {
            return fibonacci[i];
        }

        return fibonacci[i] = (getFibonacciNumber(i-1) + getFibonacciNumber(i-2))%1234567;
    }
}

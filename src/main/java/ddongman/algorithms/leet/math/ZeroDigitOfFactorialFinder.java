package ddongman.algorithms.leet.math;

public class ZeroDigitOfFactorialFinder {

    public int trailingZeroes(int n) {

        int count = 0;
        long multipliesOfFive = 5;
        while (multipliesOfFive <= n) {
            count += (int) (n / multipliesOfFive);
            multipliesOfFive *= 5;
        }

        return count;
    }
}

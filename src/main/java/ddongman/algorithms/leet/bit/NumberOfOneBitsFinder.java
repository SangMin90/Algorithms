package ddongman.algorithms.leet.bit;

public class NumberOfOneBitsFinder {

    public int hammingWeight(int n) {

        int count = 0;
        long mask = 1;
        while (mask <= n) {
            if ((n & mask) > 0) {
                count++;
            }
            mask <<= 1;
        }

        return count;
    }
}

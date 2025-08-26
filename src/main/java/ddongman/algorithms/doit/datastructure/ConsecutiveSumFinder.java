package ddongman.algorithms.doit.datastructure;

import java.util.stream.IntStream;

public class ConsecutiveSumFinder {

    public int solution(int n) {
        int[] prefixSum = prefixSumOf(n);

        return countConsecutiveSum(n, prefixSum);
    }

    private int[] prefixSumOf(int n) {
        int[] result = new int[n + 1];

        IntStream.rangeClosed(1, n)
                .forEach(i -> result[i] = result[i - 1] + i);

        return result;
    }

    private int countConsecutiveSum(int n, int[] prefixSum) {
        int count = 0;
        int i = 0;
        int j = 1;
        while (i <= j && j <= n) {
            if ((prefixSum[j] - prefixSum[i]) == n) {
                count++;
                j++;
            } else if (prefixSum[j] - prefixSum[i] > n) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}

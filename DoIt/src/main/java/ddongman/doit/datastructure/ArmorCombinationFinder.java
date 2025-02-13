package ddongman.doit.datastructure;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArmorCombinationFinder {

    public int solution(int n, int m, int[] numbers) {
        Arrays.sort(numbers);

        int[] prefixSum = prefixSumInArray(n, numbers);

        return countArmorCombinations(n, m, prefixSum);
    }

    private int[] prefixSumInArray(int n, int[] numbers) {
        int[] result = new int[n + 1];
        IntStream.rangeClosed(1, n)
                .forEach(i -> result[i] = result[i - 1] + numbers[i - 1]);

        return result;
    }

    private int countArmorCombinations(int n, int m, int[] prefixSum) {
        int count = 0;
        int i = 0;
        int j = 1;
        while (i <= j && j <= n) {
            if ((prefixSum[j] - prefixSum[i]) == m) {
                count++;
                j++;
            } else if (prefixSum[j] - prefixSum[i] > m) {
                i++;
            } else {
                j++;
            }
        }

        return count;
    }
}

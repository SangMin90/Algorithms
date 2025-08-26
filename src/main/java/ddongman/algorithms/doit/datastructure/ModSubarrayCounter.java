package ddongman.algorithms.doit.datastructure;

import java.util.stream.IntStream;

public class ModSubarrayCounter {

    public long solution(int n, int m, int[] numbers) {
        int[] prefixSum = prefixSumInArray(n, numbers);
        return countPrefixSumDivisibleByM(m, prefixSum);
    }

    private long countPrefixSumDivisibleByM(int m, int[] prefixSum) {
        return IntStream.range(1, prefixSum.length)
                .mapToLong(i -> IntStream.range(i, prefixSum.length)
                        .filter(
                                j -> (prefixSum[j] - prefixSum[i - 1]) % m == 0
                        )
                        .count()
                )
                .sum();

    }

    private int[] prefixSumInArray(int n, int[] numbers) {
        return IntStream.rangeClosed(0, n)
                .map(i -> {
                    if (i == 0) {
                        return 0;
                    } else {
                        return IntStream.rangeClosed(1, i).map(k -> numbers[k - 1]).sum();
                    }
                }).toArray();
    }
}

package ddongman.algorithms.doit.datastructure;

import java.util.stream.IntStream;

public class PrefixSum {

    public int[] ofArrayV1(int n, int q, int[] numbers, int[][] queries) {
        return IntStream.range(0, q)
                .map(i -> {
                    int startIndex = queries[i][0] - 1;
                    int endIndex = queries[i][1] - 1;

                    return IntStream.rangeClosed(startIndex, endIndex)
                            .map(j -> numbers[j])
                            .sum();
                }).toArray();
    }

    public int[] ofArrayV2(int n, int q, int[] numbers, int[][] queries) {
        int[] prefixSumFromOrigin = prefixSumInArray(n, numbers);

        return IntStream.range(0, q)
                .map(i -> {
                    int startIndex = queries[i][0] - 1;
                    int endIndex = queries[i][1];

                    return prefixSumFromOrigin[endIndex] - prefixSumFromOrigin[startIndex];
                }).toArray();
    }

    public int[] ofMatrixV1(int n, int q, int[][] matrix, int[][] queries) {
        return IntStream.range(0, q).map(i -> {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int maxPrefixSum = prefixSumInMatrixV1(0, 0, Math.max(x1, x2), Math.max(y1, y2), matrix);
            int minPrefixSum = prefixSumInMatrixV1(0, 0, Math.min(x1, x2) - 1, Math.min(y1, y2) - 1, matrix);
            int sidePrefixSum1 = prefixSumInMatrixV1(0, 0, Math.min(x1, x2) - 1, Math.max(y1, y2), matrix);
            int sidePrefixSum2 = prefixSumInMatrixV1(0, 0, Math.max(x1, x2), Math.min(y1, y2) - 1, matrix);

            return maxPrefixSum - sidePrefixSum1 - sidePrefixSum2 + minPrefixSum;
        }).toArray();
    }

    public int[] ofMatrixV2(int n, int q, int[][] matrix, int[][] queries) {
        int[][] prefixSumFromOrigin = prefixSumInMatrixV2(n, matrix);

        return IntStream.range(0, q)
                .map(i -> {
                    int x1 = queries[i][0];
                    int y1 = queries[i][1];
                    int x2 = queries[i][2];
                    int y2 = queries[i][3];
                    int maxX = Math.max(x1, x2);
                    int minX = Math.min(x1, x2);
                    int maxY = Math.max(y1, y2);
                    int minY = Math.min(y1, y2);

                    return prefixSumFromOrigin[maxX][maxY]
                            - prefixSumFromOrigin[maxX][minY - 1]
                            - prefixSumFromOrigin[minX - 1][maxY]
                            + prefixSumFromOrigin[minX - 1][minY - 1];
                })
                .toArray();
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

    private int prefixSumInMatrixV1(int x1, int y1, int x2, int y2, int[][] matrix) {
        return IntStream.rangeClosed(x1, x2)
                .map(i -> IntStream.rangeClosed(y1, y2)
                        .map(j -> matrix[i][j])
                        .reduce(0, Integer::sum)
                ).sum();
    }

    private int[][] prefixSumInMatrixV2(int n, int[][] matrix) {
        int[][] prefixMatrix = new int[n + 1][n + 1];

        IntStream.rangeClosed(1, n)
                .forEach(i -> IntStream.rangeClosed(1, n)
                        .forEach(j ->
                                prefixMatrix[i][j] = prefixMatrix[i - 1][j]
                                        + prefixMatrix[i][j - 1]
                                        + matrix[i - 1][j - 1]
                                        - prefixMatrix[i - 1][j - 1]));

        return prefixMatrix;
    }
}

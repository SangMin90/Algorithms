package ddongman.algorithms.leet.dp;

import java.util.List;
import java.util.stream.IntStream;

public class MinimumPathSumOfTriangleArray {

    private int[][] sum;
    private final int MAX = 10_000;

    public int minimumTotal(List<List<Integer>> triangle) {

        sum = new int[triangle.size()][];
        for (int i = 0; i <= triangle.size() - 1; i++) {
            sum[i] = new int[triangle.get(i).size()];
        }

        sum[0][0] = triangle.getFirst().getFirst();

        dp(1, triangle);

        int min = MAX;
        int len = sum[sum.length - 1].length;

        for (int i = 0; i < len; i++) {
            min = Math.min(min, sum[len - 1][i]);
        }

        return min;
    }

    private void dp(int depth, List<List<Integer>> triangle) {

        if (depth > triangle.size() - 1) {
            return;
        }

        List<Integer> currNodes = triangle.get(depth);
        int parentNodeLen = triangle.get(depth - 1).size();

        for (int i = 0; i < currNodes.size(); i++) {
            sum[depth][i] = Math.min(
                i - 1 >= 0 ? sum[depth - 1][i - 1] : MAX + 1,
                i <= parentNodeLen - 1 ? sum[depth - 1][i] : MAX + 1
            ) + currNodes.get(i);
        }

        dp(depth + 1, triangle);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {

        int len = triangle.size();
        int[][] nums = new int[len][];
        for (int i = 0; i < len; i++) {
            nums[i] = new int[triangle.get(i).size()];
        }

        for (int i = 0; i < len; i++) {
            nums[len - 1][i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = Math.min(nums[i + 1][j], nums[i + 1][j + 1]) +
                    triangle.get(i).get(j);
            }
        }

        return nums[0][0];
    }

    public int minimumTotal3(List<List<Integer>> triangle) {

        int len = triangle.size();
        int[] dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = triangle.get(len - 1).get(i);
        }

        for (int i = len - 2; i >= 0; i--) {

            List<Integer> currNodes = triangle.get(i);

            for (int j = 0; j < currNodes.size(); j++) {
                dp[j] = Math.min(dp[j + 1], dp[j]) + currNodes.get(j);
            }
        }

        return dp[0];
    }
}

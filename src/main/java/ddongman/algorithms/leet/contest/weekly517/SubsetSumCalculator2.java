package ddongman.algorithms.leet.contest.weekly517;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubsetSumCalculator2 {

    private final int INF = 1000000000;

    public int minOperations(int[] nums, int sum) {

        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }


        for (int i = 1; i <= n; i++) {

            // 사용 X
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // 사용 O
            Map<Integer, Integer> possible = findPossible(nums[i - 1], sum);
            for (Map.Entry<Integer, Integer> entry : possible.entrySet()) {
                int value = entry.getKey();
                int cost = entry.getValue();

                for (int j = value; j <= sum; j++) {
                    if (dp[i - 1][j - value] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - value] + cost);
                    }
                }
            }
        }

        return dp[n][sum] == INF ? -1 : dp[n][sum];
    }

    private Map<Integer, Integer> findPossible(int num, int sum) {

        Map<Integer, Integer> possible = new HashMap<>();

        int divideCnt = 0;
        int value = num;
        while (value > 1) {
            if (value <= sum) {
                possible.put(value, Math.min(possible.getOrDefault(value, INF), divideCnt));

                if (value * 2 <= sum) {
                    int multiplyCnt = 1;
                    int multiply = value * 2;
                    while (multiply <= sum) {
                        possible.put(multiply, Math.min(possible.getOrDefault(multiply, INF), divideCnt + multiplyCnt));
                        multiply *= 2;
                        multiplyCnt++;
                    }
                }
            }

            value /= 2;
            divideCnt++;
        }

        // 1부터 곱하는 경우
        int multiplyCnt = 0;
        while (value <= sum) {
            possible.put(value, Math.min(possible.getOrDefault(value, INF), divideCnt + multiplyCnt));
            value *= 2;
            multiplyCnt++;
        }

        return possible;
    }

}

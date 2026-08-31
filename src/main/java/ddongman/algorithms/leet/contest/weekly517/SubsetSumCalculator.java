package ddongman.algorithms.leet.contest.weekly517;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubsetSumCalculator {

    private final int INF = 1000000000;

    public int minOperations(int[] nums, int sum) {

        int[][] dp = new  int[nums.length + 1][sum + 1];

        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= nums.length; i++) {

            // 선택을 하지 않았을 때
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // 선택했을 때
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

        return dp[nums.length][sum] == INF ? -1 : dp[nums.length][sum];
    }

    private Map<Integer, Integer> findPossible(int num, int sum) {

        final Map<Integer, Integer> possible = new HashMap<>();

        int curr = num;
        int multiplyCnt = 0;

        while (true) {

            int value = curr;
            int divideCnt = 0;
            while (value >= 1) {
                if (value <= sum) {
                    possible.put(value, Math.min(possible.getOrDefault(value, INF), divideCnt + multiplyCnt));
                }

                divideCnt++;
                value /= 2;
            }

            if (curr > sum) {
                break;
            }

            curr *= 2;
            multiplyCnt++;
        }

        return possible;
    }
}

package ddongman.algorithms.leet.contest.weekly520;

import java.util.Arrays;

public class IntersectingPairsCounter2 {

    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        long[] sorted = new long[n];

        for (int i = 0; i < n; i++) {
            sorted[i] = (((long) intervals[i][0]) << 32) | (intervals[i][1] & 0xFFFFFFFFL);
        }

        Arrays.sort(sorted);

        long nonIntersectCount = 0;
        for (int i = 0; i < n; i++) {
            long interval = sorted[i];
            long end = interval & 0xFFFFFFFFL;

            int low = i + 1;
            int high = n - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                long start = sorted[mid] >>> 32;
                if (start <= end) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            nonIntersectCount += n - low;

        }

        long totalCnt = (((long) n) * (n - 1) / 2);
        return totalCnt - nonIntersectCount;
    }

    public long countIntersectingIntervals2(int[][] intervals) {

        long ans = 0;

        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && end[j] < start[i]) {
                j++;
            }

            // i: 현재까지의 interval 개수, j: 끝나버린 interval 개수
            ans += i - j;
            i++;
        }

        return ans;
    }
}

package ddongman.algorithms.leet.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalsMerger {

    public int[][] merge(int[][] intervals) {

        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals
            , Comparator.comparingInt(a -> a[0]));

        int[] before = {intervals[0][0], intervals[0][1]};
        int i = 0;
        while (i < intervals.length) {
            int[] curr = intervals[i];

            if (before[0] <= curr[0] && curr[0] <= before[1]) {
                before[1] = Math.max(before[1], curr[1]);
            } else {
                result.add(new int[]{before[0], before[1]});
                before[0] = curr[0];
                before[1] = curr[1];
            }

            i++;
        }

        result.add(before);

        return result.toArray(int[][]::new);
    }

    public int[][] merge2(int[][] intervals) {

        Arrays.sort(intervals
            , Comparator.comparingInt(a -> a[0]));

        List<int[]> result = new ArrayList<>();

        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }

        return result.toArray(int[][]::new);
    }

    public int[][] merge3(int[][] intervals) {

        int n = intervals.length;
        int[] startPoint = new int[n];
        int[] endPoint = new int[n];

        for (int i = 0; i < n; i++) {
            startPoint[i] = intervals[i][0];
            endPoint[i] = intervals[i][1];
        }

        Arrays.sort(startPoint);
        Arrays.sort(endPoint);

        int start = startPoint[0];
        int s = 1;
        List<int[]> result = new ArrayList<>();
        while (s < n) {
            if (startPoint[s] > endPoint[s - 1]) {
                result.add(new int[]{start, endPoint[s - 1]});
                start = startPoint[s];
            }

            s++;
        }

        result.add(new int[]{start, endPoint[s - 1]});

        return result.toArray(int[][]::new);
    }
}

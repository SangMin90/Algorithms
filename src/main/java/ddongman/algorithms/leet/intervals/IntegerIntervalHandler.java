package ddongman.algorithms.leet.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerIntervalHandler {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        boolean isOverlapped = false;
        int index = 0;
        while (index < intervals.length) {

            int targetIndex = index;
            int start = intervals[targetIndex][0];
            int end = intervals[targetIndex][1];
            while (targetIndex < intervals.length && isOverlapped(intervals[targetIndex], newInterval)) {
                start = Math.min(start, Math.min(intervals[targetIndex][0], newInterval[0]));
                end = Math.max(end, Math.max(intervals[targetIndex][1], newInterval[1]));
                targetIndex++;
            }

            if (targetIndex == index) {
                index++;
            } else {
                index = targetIndex;
                isOverlapped = true;
            }

            result.add(new int[]{start, end});
        }

        if (!isOverlapped) {
            int insertIndex = 0;
            while (insertIndex < result.size() && result.get(insertIndex)[0] < newInterval[0]) {
               insertIndex++;
            }

            result.add(insertIndex, newInterval);
        }

        return result.toArray(new int[0][0]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int len = intervals.length;
        int index = 0;

        while (index < len && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index++]);
        }

        while (index < len && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0],intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[index][1]);
            index++;
        }
        result.add(newInterval);

        while (index < len) {
            result.add(intervals[index++]);
        }

        return result.toArray(new int[0][0]);
    }


    private boolean isOverlapped(int[] i1, int[] i2) {

        return (i1[0] <= i2[0] && i2[0] <= i1[1]) ||
            (i2[0] <= i1[0] && i1[0] <= i2[1]);
    }
}

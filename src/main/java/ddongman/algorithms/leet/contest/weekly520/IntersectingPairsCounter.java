package ddongman.algorithms.leet.contest.weekly520;

import java.util.Arrays;

public class IntersectingPairsCounter {

    public int countIntersectingIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }

            return Integer.compare(o1[0], o2[0]);
        });

        int count = 0;

        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                int[] pointI = intervals[i];
                int[] pointJ =  intervals[j];

                if (pointI[0] <= pointJ[0] && pointJ[0] <= pointI[1]) {
                    count++;
                }
            }
        }

        return count;
    }
}

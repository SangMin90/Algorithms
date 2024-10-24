package ddongman.doit.geometric;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LineSegmentGrouper {
    public int[] solution(int n, int[][] segments) {

        if (segments == null || segments.length == 0 || n == 0) {
            return new int[]{0, 0};
        }


        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isCross(segments[i], segments[j])) {
                    if (map.containsKey(i)) {
                        map.put(j, map.get(i));
                    } else if (map.containsKey(j)) {
                        map.put(i, map.get(j));
                    } else {
                        map.put(i, i);
                        map.put(j, i);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, i);
        }

        Map<Integer, List<Integer>> groups = map.entrySet()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Map.Entry::getValue
                                , Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                        )
                );

        return new int[]{groups.size(), groups.values().stream().map(List::size).max(Integer::compare).orElse(0)};
    }

    private boolean isCross(int[] segment1, int[] segment2) {
        int[] startPointOfSegment1 = new int[]{segment1[0], segment1[1]};
        int[] endPointOfSegment1 = new int[]{segment1[2], segment1[3]};

        int[] startPointOfSegment2 = new int[]{segment2[0], segment2[1]};
        int[] endPointOfSegment2 = new int[]{segment2[2], segment2[3]};

        int acb = ccw(startPointOfSegment1, startPointOfSegment2, endPointOfSegment1);
        int adb = ccw(startPointOfSegment1, endPointOfSegment2, endPointOfSegment1);

        int cad = ccw(startPointOfSegment2, startPointOfSegment1, endPointOfSegment2);
        int cbd = ccw(startPointOfSegment2, endPointOfSegment1, endPointOfSegment2);

        return ((acb * adb < 0) && (cad * cbd < 0))
                || (
                        (acb * adb * cad * cbd == 0)
                        && (
                                (
                                    ((startPointOfSegment1[0] - startPointOfSegment2[0]) * (endPointOfSegment1[0] - startPointOfSegment2[0]) <= 0)
                                    && ((startPointOfSegment1[1] - startPointOfSegment2[1]) * (endPointOfSegment1[1] - startPointOfSegment2[1]) <= 0)
                                )
                                || (
                                    ((startPointOfSegment1[0] - endPointOfSegment2[0]) * (endPointOfSegment1[0] - endPointOfSegment2[0]) <= 0)
                                    && ((startPointOfSegment1[1] - endPointOfSegment2[1]) * (endPointOfSegment1[1] - endPointOfSegment2[1]) <= 0)
                                )
                                || (
                                    ((startPointOfSegment2[0] - startPointOfSegment1[0]) * (endPointOfSegment2[0] - startPointOfSegment1[0]) <= 0)
                                    && ((startPointOfSegment2[1] - startPointOfSegment1[1]) * (endPointOfSegment2[1] - startPointOfSegment1[1]) <= 0)
                                )
                                || (
                                    ((startPointOfSegment2[0] - endPointOfSegment1[0]) * (endPointOfSegment2[0] - endPointOfSegment1[0]) <= 0)
                                    && ((startPointOfSegment2[1] - endPointOfSegment1[1]) * (endPointOfSegment2[1] - endPointOfSegment1[1]) <= 0)
                                )
                        )
                );


    }

    private int ccw(int[] segment1, int[] segment2, int[] segment3) {
        return (segment1[0] * segment2[1] + segment2[0] * segment3[1] + segment3[0] * segment1[1])
                - (segment2[0] * segment1[1] + segment3[0] * segment2[1] + segment1[0] * segment3[1]);
    }
}

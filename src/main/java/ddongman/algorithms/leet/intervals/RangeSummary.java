package ddongman.algorithms.leet.intervals;

import java.util.ArrayList;
import java.util.List;

public class RangeSummary {

    public List<String> summaryRanges(int[] nums) {

        if (nums == null || nums.length == 0) {
            return List.of();
        }

        List<String> ranges = new ArrayList<>();

        int start = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1] + 1) {
                ranges.add(convertRange(start, i - 1, nums));
                start = i;
            }
        }

        ranges.add(convertRange(start, nums.length - 1, nums));

        return ranges;
    }

    public List<String> summaryRanges2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return List.of();
        }

        List<String> ranges = new ArrayList<>();
        int start = 0;
        while (start < nums.length) {

            int end = start;
            while (end < nums.length - 1 && nums[end + 1] == nums[end] + 1) {
                end++;
            }

            if (start == end) {
                ranges.add(String.valueOf(nums[start]));
            } else {
                ranges.add(String.format("%d->%d", nums[start], nums[end]));
            }

            start = end + 1;
        }

        return ranges;
    }

    public List<String> summaryRanges3(int[] nums) {

        if (nums == null || nums.length == 0) {
            return List.of();
        }

        StringBuilder sb = new StringBuilder();
        List<String> ranges = new ArrayList<>();
        int start = 0;
        while (start < nums.length) {

            int end = start;
            while (end < nums.length - 1 && nums[end + 1] == nums[end] + 1) {
                end++;
            }

            sb.append(nums[start]);

            if (start != end) {
                sb.append("->").append(nums[end]);
            }

            ranges.add(sb.toString());

            sb.setLength(0);
            start = end + 1;
        }

        return ranges;
    }



    private String convertRange(int start, int end, int[] nums) {
        if (start == end) {
            return String.valueOf(nums[start]);
        }

        return String.format("%d->%d", nums[start], nums[end]);
    }
}

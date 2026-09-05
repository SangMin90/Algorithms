package ddongman.algorithms.leet.bst;

public class PeakElementFinder {

    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            } else if (i == nums.length - 1) {
                if (nums[i] > nums[i - 1]) {
                    return i;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }

        throw new IllegalArgumentException("조건을 만족하는 수가 없습니다.");
    }

    public int findPeakElement2(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < nums[mid + 1]) {
                start = mid + 1;
            } else if (nums[mid] > nums[mid + 1]) {
                end = mid;
            }
        }

        return start;
    }
}

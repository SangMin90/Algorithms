package ddongman.algorithms.leet.bst;

public class InsertPositionFinder {

    public int searchInsert(int[] nums, int target) {

        return binarySearch(nums, 0, nums.length - 1, target);
//        return binarySearchWithBottomUp(nums, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {

        if (start >= end) {
            return nums[start] < target ? start + 1 : start;
        }

        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }

        return binarySearch(nums, mid + 1, end, target);
    }

    private int binarySearchWithBottomUp(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return start;
    }
}

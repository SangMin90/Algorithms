package ddongman.algorithms.leet.array;

public class DuplicatedElementRemover {

    public int removeDuplicates(int[] nums) {

        int[] count = new int[20001];

        for (int num : nums) {
            count[num + 10000]++;
        }

        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 1) {
                nums[idx++] = i - 10000;
            } else if (count[i] >= 2) {
                nums[idx++] = i - 10000;
                nums[idx++] = i - 10000;
            }
        }

        return idx;
    }

    public int removeDuplicates2(int[] nums) {

        int targetIdx = 0;
        int idx = 0;
        while (idx < nums.length) {

            int startIndex = idx;
            int cnt = 0;
            while (idx < nums.length && nums[startIndex] == nums[idx]) {
                nums[targetIdx + cnt] = nums[idx];
                idx++;
                cnt++;
            }

            if (cnt == 1) {
                nums[targetIdx] = nums[idx - 1];
                targetIdx++;
            }

            if (cnt > 1) {
                targetIdx = targetIdx + 2;
            }
        }

        return targetIdx;
    }

    public int removeDuplicates3(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}

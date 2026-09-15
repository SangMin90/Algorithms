package ddongman.algorithms.leet.contest.weekly519;

public class ShadowPairCounter {

    public long shadowPairs(int[] nums) {

        long count = 0;
        int k = 0;
        int[] stack = new int[nums.length];

        for (int num : nums) {
            while (k > 0 && stack[k - 1] > num) {
                k--;
            }

            int l = 0;
            int r = k;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (stack[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            count += l;
            stack[k++] = num;
        }

        return count;
    }
}

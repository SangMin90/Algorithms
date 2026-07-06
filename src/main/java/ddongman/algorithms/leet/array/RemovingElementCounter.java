package ddongman.algorithms.leet.array;

public class RemovingElementCounter {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int temp = nums.length - 1;
        int index = 0;
        while (index <= temp) {

            if (nums[index] == val) {
                while (temp > index && nums[temp] == val) {
                    temp--;
                }

                nums[index] = nums[temp];
                nums[temp] = val;

                temp--;
            } else {
                index++;
            }
        }

        return index;
    }

    public int removeElement2(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    public int removeElement3(int[] nums, int val) {

        int i = 0;
        int n = nums.length;

        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }

        return n;
    }
}

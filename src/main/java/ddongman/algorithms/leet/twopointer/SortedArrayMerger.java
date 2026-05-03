package ddongman.algorithms.leet.twopointer;

public class SortedArrayMerger {

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {

            int num1 = nums1[i];
            int num2 = nums2[j];

            if (num1 < num2) {
                nums1[i + j + 1] = num2;
                j--;
            } else {
                nums1[i + j + 1] = num1;
                i--;
            }
        }

        while (i >= 0) {

            nums1[i + j + 1] = nums1[i];
            i--;
        }

        while (j >= 0) {

            nums1[i + j + 1] = nums2[j];
            j--;
        }

        return nums1;
    }
}

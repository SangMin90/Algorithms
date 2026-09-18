package ddongman.algorithms.leet.twopointer;

public class ContainerWithMostWaterFinder {

    public int maxArea(int[] height) {

        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {

            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int h = Math.min(height[i], height[j]);
            max = Math.max(max, h * (j - i));

            while (i < j && height[i] <= h) {
                i++;
            }

            while (i < j && height[j] <= h) {
                j--;
            }
        }

        return max;
    }
}

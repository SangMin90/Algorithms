package ddongman.algorithms.leet.twopointer;

public class TargetNumberFinderWithTwoSum {

    public int[] twoSum(int[] numbers, int target) {

        int start = 0;
        int end = numbers.length - 1;

        int[] result = {start, end};

        while (start < end) {
            int sum = numbers[start] + numbers[end];

            if (sum == target) {
                result[0] = start + 1;
                result[1] = end + 1;

                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }

        return result;
    }
}

package ddongman.doit.datastructure;

import java.util.Arrays;

public class IntegerPartition {

    public int solution(int n, int[] numbers) {
        Arrays.sort(numbers);

        return countCombination(n, numbers);
    }

    private int countCombination(int n, int[] numbers) {
        int count = 0;
        int i = 0;
        int j = 1;
        int k = 2;
        while (i < j && j < k && k < n) {
            if (numbers[k] == (numbers[i] + numbers[j])) {
                count++;
                k++;
            } else if (numbers[k] > (numbers[i] + numbers[j])) {
                j++;
            } else {
                k++;
            }
        }

        return count;
    }
}

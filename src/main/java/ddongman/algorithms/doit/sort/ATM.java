package ddongman.algorithms.doit.sort;

import java.util.stream.IntStream;

public class ATM {

    public int solution(int n, int[] numbers) {
        insertionSort(numbers);

        return getTotalWaitingTime(numbers);
    }

    private void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int j = i - 1;
            while (j >= 0 && numbers[j] > numbers[j + 1]) {
                swap(j, j + 1, numbers);
                j--;
            }
        }
    }

    private void swap(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private int getTotalWaitingTime(int[] numbers) {
        int n = numbers.length;
        return IntStream.range(0, n)
                .map(i -> (n - i) * numbers[i])
                .sum();
    }
}

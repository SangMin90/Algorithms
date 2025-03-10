package ddongman.doit.sort;

import java.util.stream.IntStream;

public class MergeSort {

    private int[] tempArr;

    public int[] solution(int n, int[] numbers) {
        tempArr = new int[n];

        mergeSort(numbers, 0, n - 1);

        return numbers;
    }

    private void mergeSort(int[] numbers, int i, int j) {
        if (i >= j) {
            return;
        }

        int middle = (i + j) / 2;
        mergeSort(numbers, i, middle);
        mergeSort(numbers, middle + 1, j);
        merge(numbers, i, middle, j);
    }

    private void merge(int[] numbers, int start, int middle, int end) {
        if (start >= end) {
            return;
        }

        int k = start;
        int left = start;
        int right = middle + 1;
        while (left <= middle && right <= end) {
            if (numbers[left] <= numbers[right]) {
                tempArr[k] = numbers[left];
                left++;
            } else {
                tempArr[k] = numbers[right];
                right++;
            }
            k++;
        }

        while (left <= middle) {
            tempArr[k] = numbers[left];
            k++;
            left++;
        }

        while (right <= end) {
            tempArr[k] = numbers[right];
            k++;
            right++;
        }

        IntStream.rangeClosed(start, end)
                .forEach(i -> numbers[i] = tempArr[i]);
    }
}

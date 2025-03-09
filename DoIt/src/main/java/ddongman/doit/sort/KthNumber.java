package ddongman.doit.sort;

public class KthNumber {
    public int solutionMedian(int n, int k, int[] numbers) {
        quickSortMedian(numbers, 0, n - 1);

        return numbers[k - 1];
    }

    public int solutionLeft(int n, int k, int[] numbers) {
        quickSortLeft(numbers, 0, n - 1);

        return numbers[k - 1];
    }

    public int solutionRight(int n, int k, int[] numbers) {
        quickSortRight(numbers, 0, n - 1);

        return numbers[k - 1];
    }

    private void quickSortMedian(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left, j = right;
        int pivot = numbers[(i + j) / 2];

        while (i <= j) {
            while (pivot > numbers[i]) {
                i++;
            }

            while (pivot < numbers[j]) {
                j--;
            }

            if (i <= j) {
                swap(i, j, numbers);
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSortMedian(numbers, left, j);
        }

        if (right > i) {
            quickSortMedian(numbers, i, right);
        }
    }

    private void quickSortLeft(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partitionLeft(numbers, left, right);
        quickSortLeft(numbers, left, pivot - 1);
        quickSortLeft(numbers, pivot + 1, right);
    }

    private void quickSortRight(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivot = partitionRight(numbers, left, right);
        quickSortRight(numbers, left, pivot - 1);
        quickSortRight(numbers, pivot + 1, right);
    }

    private int partitionRight(int[] numbers, int left, int right) {
        int pivot = numbers[right];
        int low = left, high = right - 1;

        while (low <= high) {
            while (numbers[low] < pivot) {
                low++;
            }

            while (left <= high && numbers[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swap(low, high, numbers);
            }
        }

        swap(low, right, numbers);

        return low;
    }

    private int partitionLeft(int[] numbers, int left, int right) {
        int pivot = numbers[left];
        int low = left + 1, high = right;

        while (low <= high) {
            while (low <= right && numbers[low] < pivot) {
                low++;
            }

            while (numbers[high] > pivot) {
                high--;
            }

            if (low <= high) {
                swap(low, high, numbers);
            }
        }

        swap(left, high, numbers);

        return high;
    }

    private void swap(int i, int j, int[] numbers) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

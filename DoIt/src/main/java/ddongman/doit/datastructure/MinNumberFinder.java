package ddongman.doit.datastructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.IntStream;

public class MinNumberFinder {
    public int[] solution(int n, int l, int[] numbers) {
        return findMinNumbers(n, l, numbers);
    }

    private int[] findMinNumbers(int n, int l, int[] numbers) {
        int[] minNumbers = new int[n];
        Integer minNumber = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (queue.size() == l) {
                Integer polled = queue.poll();
                if (minNumber.compareTo(Objects.requireNonNull(polled)) == 0) {
                    minNumber = getMinNumber(queue);
                }
            }

            int added = numbers[i];
            queue.add(added);

            if (added <= minNumber) {
                minNumber = added;
            }

            minNumbers[i] = minNumber;
        }

        return minNumbers;
    }

    private int getMinNumber(Queue<Integer> queue) {
        return queue.stream()
                .min(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }
}

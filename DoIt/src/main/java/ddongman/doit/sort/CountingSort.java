package ddongman.doit.sort;

import java.util.*;

public class CountingSort {

    public int[] solution(int n, int[] numbers) {
        int max = findMax(numbers);
        int digit = getDigit(max);

        List<Deque<Integer>> emptyQueues = createEmptyQueue();

        sort(numbers, emptyQueues, digit);

        return numbers;
    }

    private void sort(int[] numbers, List<Deque<Integer>> queues, int digit) {
        int base = 1;
        while (digit-- > 0) {
            // 수를 큐에 넣음
            for (int number : numbers) {
                int targetIdx = (number / base) % 10;
                queues.get(targetIdx).add(number);
            }

            // 큐에서 수를 정렬
            int index = 0;
            for (Deque<Integer> queue : queues) {
                while (!queue.isEmpty()) {
                    numbers[index] = queue.poll();
                    index++;
                }
            }

            base *= 10;
        }
    }

    private int findMax(int[] numbers) {
        return Arrays.stream(numbers)
                .max()
                .orElseThrow(
                        () -> new ArithmeticException("최댓값이 없습니다.")
                );
    }

    private int getDigit(int num) {
        int digit = 0;

        while (num > 0) {
            num /= 10;
            digit++;
        }

        return digit;
    }

    private List<Deque<Integer>> createEmptyQueue() {
        List<Deque<Integer>> emptyQueue = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            emptyQueue.add(new ArrayDeque<>());
        }
        return emptyQueue;
    }
}

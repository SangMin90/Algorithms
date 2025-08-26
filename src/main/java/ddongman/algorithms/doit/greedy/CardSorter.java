package ddongman.algorithms.doit.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CardSorter {
    public long solution(int n, int[] cards) {
        // 카드 묶음 정렬
        Arrays.sort(cards);

        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                sum += (long) cards[i] * (n - 1);
            } else {
                sum += (long) cards[i] * (n - i);
            }
        }

        return sum;
    }

    public long solution2(int n, int[] cards) {
        PriorityQueue<Long> cardQueue = new PriorityQueue<>();

        // 우선순위 큐에 저장
        for (int i = 0; i < n; i++) {
            cardQueue.add((long) cards[i]);
        }

        long sum = 0;
        while (cardQueue.size() > 1) {
            long bundle = cardQueue.remove() + cardQueue.remove();
            sum += bundle;
            cardQueue.add(bundle);
        }

        return sum;
    }
}

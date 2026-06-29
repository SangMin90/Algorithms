package ddongman.algorithms.leet.heap;

import java.util.Objects;
import java.util.PriorityQueue;

public class ArrayUtils {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2, o1));

        for (int num : nums) {
            pq.offer(num);
        }

        int count = 0;
        while (++count < k) {
            pq.poll();
        }

        return Objects.requireNonNull(pq.poll());
    }

    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);

        for (int num : nums) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return Objects.requireNonNull(pq.poll());
    }

    public int findKthLargest3(int[] nums, int k) {
        final int MAX = 10000;
        int[] counts = new int[2 * MAX + 1];

        for (int num : nums) {
            counts[num + MAX]++;
        }

        int result = 0;
        int count = 0;
        for (int i = counts.length - 1; i >= 0; i--) {

            count += counts[i];
            if (count >= k) {
                result = i;
                break;
            }
        }

        return result - MAX;
    }
}

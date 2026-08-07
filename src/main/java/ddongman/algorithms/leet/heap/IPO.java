package ddongman.algorithms.leet.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int len = profits.length;
        Project[] projects = new Project[len];

        for (int i = 0; i < len; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects, Comparator.comparingInt(o -> o.capital));

        PriorityQueue<Project> queue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2.profit, o1.profit));

        int idx = 0;
        while (k-- > 0) {
            while (idx < projects.length) {
                if (projects[idx].capital <= w) {
                    queue.add(projects[idx]);
                    idx++;
                } else {
                    break;
                }
            }

            if (queue.isEmpty()) {
                break;
            }

            w += Objects.requireNonNull(queue.poll()).profit;
        }

        return w;
    }

    record Project(int capital, int profit) { }

    public int findMaximizedCapital2(int k, int w, int[] profits, int[] capital) {

        int len = profits.length;
        long[] projects = new long[len];

        for (int i = 0; i < len; i++) {
            projects[i] = ((long) capital[i] << 32) | profits[i] & 0xFFFFFFFFL;
        }

        Arrays.sort(projects);
        int[] heap = new int[len];
        int size = 0;
        int index = 0;
        for (int round = 0; round < k; round++) {

            while (index < projects.length && (int)(projects[index] >> 32) <= w) {
                heap[size] = profits[index];
                siftUp(heap, size);
                index++;
                size++;
            }

            if (size == 0) {
                break;
            }

            w += heap[0];

            heap[0] = heap[--size];
            siftDown(heap, 0, size);
        }

        return w;
    }

    private void siftDown(int[] heap, int i, int size) {

        int value = heap[i];

        while (true) {

            int c = i * 2 + 1;
            if (c + 1 <= size && heap[c + 1] > heap[c]) {
                c++;
            }

            if (heap[c] <= value) {
                break;
            }

            heap[i] = heap[c];
            i = c;
        }

        heap[i] = value;
    }

    private void siftUp(int[] heap, int i) {

        int value = heap[i];

        while (i > 0) {
            int p = (i - 1) >>> 1;

            if (heap[p] >= value) {
                break;
            }

            heap[i] = heap[p];
            i = p;
        }

        heap[i] = value;
    }
}

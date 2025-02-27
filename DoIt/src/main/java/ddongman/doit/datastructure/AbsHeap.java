package ddongman.doit.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class AbsHeap {

    public int[] solution(int n, int[] numbers) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) != Math.abs(o2)) {
                return Math.abs(o1) - Math.abs(o2);
            } else {
                return o1.compareTo(o2);
            }
        });

        List<Integer> result = new ArrayList<>();

        IntStream.range(0, n)
                .forEach(i -> {
                    if (numbers[i] != 0) {
                        heap.offer(numbers[i]);
                    } else {
                        if (heap.isEmpty()) {
                            result.add(0);
                        } else {
                            result.add(heap.poll());
                        }
                    }
                });
        return result.stream().mapToInt(i -> i).toArray();
    }
}

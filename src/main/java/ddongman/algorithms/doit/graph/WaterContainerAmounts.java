package ddongman.algorithms.doit.graph;

import java.util.*;

import static ddongman.algorithms.doit.graph.WaterContainerAmounts.Direction.*;

public class WaterContainerAmounts {

    private int[] CAPACITY;
    private boolean[][] visited;
    private final Queue<int[]> queue = new LinkedList<>();
    private final List<Integer> result = new ArrayList<>();

    public int[] solution(int a, int b, int c) {
        visited = new boolean[a + 1][b + 1];
        CAPACITY = new int[]{a, b, c};

        queue.add(new int[]{0, 0, c});
        visited[0][0] = true;
        result.add(c);

        while (!queue.isEmpty()) {
            int[] containers = queue.poll();

            pour(containers, A_TO_B);
            pour(containers, A_TO_C);
            pour(containers, B_TO_A);
            pour(containers, B_TO_C);
            pour(containers, C_TO_A);
            pour(containers, C_TO_B);
        }

        Collections.sort(result);
        
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void pour(int[] containers, Direction direction) {
        int[] next = Arrays.copyOf(containers, containers.length);

        int from = direction.getFrom();
        int to = direction.getTo();

        int amount = Math.min(containers[from], CAPACITY[to] - containers[to]);

        if (amount == 0) {
            return;
        }

        next[from] = containers[from] - amount;
        next[to] = containers[to] + amount;

        if (visited[next[0]][next[1]]) {
            return;
        }

        visited[next[0]][next[1]] = true;

        if (next[0] == 0) {
            result.add(next[2]);
        }

        queue.add(next);
    }

    enum Direction {
        A_TO_B(0, 1),
        A_TO_C(0, 2),
        B_TO_A(1, 0),
        B_TO_C(1, 2),
        C_TO_A(2, 0),
        C_TO_B(2, 1);

        private final int from;
        private final int to;


        Direction(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }
    }
}

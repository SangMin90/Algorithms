package ddongman.doit.search;

import java.util.*;

public class BFS {
    private boolean[] visited;
    private PriorityQueue<Integer>[] link;
    private Queue<Integer> queue;
    private List<Integer> result;

    public int[] solution(int n, int m, int v, int[][] arr) {
        init(n, m, arr);
        bfs(v);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private void init(int n, int m, int[][] arr) {
        visited = new boolean[n + 1];

        link = new PriorityQueue[n + 1];
        for (int i = 0; i <= n; i++) {
            link[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < m; i++) {
            link[arr[i][0]].add(arr[i][1]);
            link[arr[i][1]].add(arr[i][0]);
        }

        queue = new LinkedList<>();

        result = new ArrayList<>();
    }

    public void bfs(int i) {
        if (visited[i]) {
            return;
        }

        queue.add(i);
        visited[i] = true;

        while (!queue.isEmpty()) {
            int k = queue.poll();
            result.add(k);
            while (!link[k].isEmpty()) {
                int j = link[k].poll();
                if (!visited[j]) {
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}

package ddongman.algorithms.doit.graph.tree;

import java.util.*;

public class TreeFinder {

    private static int ROOT = 1;

    private List<Integer>[] graph;
    private boolean[] visited;
    private Queue<Integer> queue = new LinkedList<>();
    private int[] parents;

    public int[] solution(int N, int[][] edges) {

        init(N, edges);

        findParents();

        return Arrays.copyOfRange(parents, 2, N + 1);
    }

    private void init(int N, int[][] edges) {
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        parents[1] = ROOT;

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge: edges) {
            int edge1 = edge[0];
            int edge2 = edge[1];

            graph[edge1].add(edge2);
            graph[edge2].add(edge1);
        }
    }

    private void findParents() {
        queue.add(ROOT);
        while (!queue.isEmpty()) {
            Integer parent = queue.poll();
            visited[parent] = true;

            for (int child: graph[parent]) {
                if (!visited[child]) {
                    queue.add(child);
                    this.parents[child] = parent;
                }
            }
        }
    }
}

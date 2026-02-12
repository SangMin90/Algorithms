package ddongman.algorithms.doit.graph.bellman;

import java.util.stream.IntStream;

public class BellmanFord {

    private Edge[] edges;
    private int[] dist;

    public int[] solution(int V, int E, int start, int[][] graph) {
        init(V, E, start, graph);
        bellmanFord(V);

        if (isNegativeCycle()) {
            return new int[]{-1};
        }

        return IntStream.rangeClosed(1, V)
                .filter(i -> i != start)
                .map(i -> {
                    if (dist[i] == Integer.MAX_VALUE) {
                        return -1;
                    }
                    return dist[i];
                })
                .toArray();
    }

    private void init(int V, int E, int start, int[][] graph) {
        edges = new Edge[E];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        for (int i = 0; i < E; i++) {
            int from = graph[i][0];
            int to = graph[i][1];
            int weight = graph[i][2];

            edges[i] = new Edge(from, to, weight);
        }
    }

    private void bellmanFord(int V) {
        int i = V;
        while (--i >= 0) {
            for (Edge edge : edges) {
                int from = edge.getFrom();
                if (dist[from] != Integer.MAX_VALUE) {
                    int to = edge.getTo();
                    int weight = edge.getWeight();
                    if (dist[to] > dist[from] + weight) {
                        dist[to] = dist[from] + weight;
                    }
                }
            }
        }
    }

    private boolean isNegativeCycle() {
        for (Edge edge : edges) {
            int from = edge.getFrom();
            if (dist[from] != Integer.MAX_VALUE) {
                int to = edge.getTo();
                int weight = edge.getWeight();
                if (dist[to] > dist[from] + weight) {
                    return true;
                }
            }
        }

        return false;
    }

    static class Edge {
        private final int from;
        private final int to;
        private final int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }
}

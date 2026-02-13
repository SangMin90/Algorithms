package ddongman.algorithms.doit.graph.bellman;

import java.util.*;

public class Salesman {

    public Object solution(int N, int start, int end,
                           int M, int[][] graph,
                           int[] sales) {
        BellmanFord bellmanFord = new BellmanFord(N, M, start, graph, sales);
        bellmanFord.bellmanFord(N);
        Bfs bfs = new Bfs(N, graph);

        long[] dist = bellmanFord.getDist();
        if (dist[end] == Long.MAX_VALUE) {
            return "gg";
        }

        if (bellmanFord.isNegativeCycleConnectedToEnd(bfs, end)) {
            return "Gee";
        }

        return -dist[end];
    }

    static class BellmanFord {
        private final Edge[] edges;
        private final long[] dist;

        public BellmanFord(int N, int M, int start, int[][] graph, int[] sales) {
            this.edges = new Edge[M];
            this.dist = new long[N];

            for (int i = 0; i < M; i++) {
                int from = graph[i][0];
                int to = graph[i][1];
                int weight = graph[i][2] - sales[to];

                edges[i] = new Edge(from, to, weight);
            }

            for (int i = 0; i < N; i++) {
                dist[i] = Long.MAX_VALUE;
            }

            dist[start] = -sales[start];
        }

        public void bellmanFord(int N) {
            int i = N;
            while (--i > 0) {
                Arrays.stream(edges)
                        .filter(edge -> {
                            int from = edge.getFrom();
                            return dist[from] != Long.MAX_VALUE;
                        })
                        .forEach(edge -> {
                            int from = edge.getFrom();
                            int to = edge.getTo();
                            int weight = edge.getWeight();
                            if (dist[to] > dist[from] + weight) {
                                dist[to] = dist[from] + weight;
                            }
                        });
            }
        }

        public boolean isNegativeCycleConnectedToEnd(Bfs bfs, int end) {
            return Arrays.stream(edges)
                    .filter(edge -> {
                        int from = edge.getFrom();
                        int to = edge.getTo();
                        int weight = edge.getWeight();
                        return dist[from] != Long.MAX_VALUE &&
                                dist[to] > dist[from] + weight;
                    })
                    .anyMatch(edge -> {
                        int to = edge.getTo();
                        bfs.bfs(to);
                        boolean[] visited = bfs.getVisited();
                        return visited[end];
                    });
        }

        public long[] getDist() {
            return dist;
        }
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

    static class Bfs {
        private final List<Integer>[] link;
        private final Queue<Integer> queue;
        private final boolean[] visited;

        public Bfs(int N, int[][] graph) {
            this.link = new ArrayList[N];
            this.queue = new LinkedList<>();
            this.visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                link[i] = new ArrayList<>();
            }

            for (int[] edge : graph) {
                int from = edge[0];
                int to = edge[1];
                link[from].add(to);
            }
        }

        private void bfs(int start) {
            if (visited[start]) {
                return;
            }

            queue.add(start);
            visited[start] = true;

            while (!queue.isEmpty()) {
                Integer from = queue.poll();
                for (Integer to : link[from]) {
                    if (!visited[to]) {
                        queue.add(to);
                        visited[to] = true;
                    }
                }
            }
        }

        public boolean[] getVisited() {
            return visited;
        }
    }
}

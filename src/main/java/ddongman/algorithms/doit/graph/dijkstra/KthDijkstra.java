package ddongman.algorithms.doit.graph.dijkstra;

import java.util.*;
import java.util.stream.IntStream;

public class KthDijkstra {

    public int[] solution(int n, int m, int k, int[][] graph) {
        int start = 1;
        Dijkstra dijkstra = new Dijkstra(n, graph);
        dijkstra.dijkstra(start, n, k);

        return dijkstra.findKthShortestPath(n, k);
    }

    static class Dijkstra {

        private final int[][] adj;
        private final PriorityQueue<Integer>[] dist;
        private final PriorityQueue<Node> queue;

        public Dijkstra(int n, int[][] graph) {
            this.adj = new int[n + 1][n + 1];
            this.dist = new PriorityQueue[n + 1];
            this.queue = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                dist[i] = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
            }

            for (int[] edge: graph) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                adj[u][v] = w;
            }
        }

        public void dijkstra(int start, int n, int k) {
            queue.add(new Node(start, 0));
            dist[start].add(0);
            while (!queue.isEmpty()) {
                Node u = queue.poll();

                for (int i = 1; i <= n; i++) {
                    if (adj[u.getVertex()][i] == 0) {
                        continue;
                    }

                    int distance = u.getDist() + adj[u.getVertex()][i];
                    if (dist[i].size() < k) {
                        dist[i].add(distance);
                        queue.add(new Node(i, distance));
                    } else if (dist[i].peek() > distance) {
                        dist[i].poll();
                        dist[i].add(distance);
                        queue.add(new Node(i, distance));
                    }
                }
            }
        }

        public int[] findKthShortestPath(int n, int k) {
            return IntStream.rangeClosed(1, n)
                    .map(vertex -> {
                        if (dist[vertex].size() < k) {
                            return -1;
                        }
                        return dist[vertex].peek();
                    })
                    .toArray();
        }
    }

    static class Node implements Comparable<Node> {
        private final int vertex;
        private final int dist;

        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }

        public int getVertex() {
            return vertex;
        }

        public int getDist() {
            return dist;
        }


        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.getDist(), o.getDist());
        }
    }
}

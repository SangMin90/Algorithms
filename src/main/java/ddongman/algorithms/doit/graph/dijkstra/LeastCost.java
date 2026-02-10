package ddongman.algorithms.doit.graph.dijkstra;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LeastCost {

    public int solution(int N, int M, int[][] graph, int from, int to) {
        Dijkstra dijkstra = new Dijkstra(N, M, graph, from);
        dijkstra.dijkstra(from);
        return dijkstra.getLeastCostTo(to);
    }

    static class Dijkstra {

        private List<Edge>[] link;
        private PriorityQueue<Node> queue;
        private boolean[] visited;
        private int[] dist;

        public Dijkstra(int N, int M, int[][] graph, int from) {
            this.link = new ArrayList[N + 1];
            this.queue = new PriorityQueue<>();
            this.visited = new boolean[N + 1];
            this.dist = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                link[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {

                int u = graph[i][0];
                int v = graph[i][1];
                int w = graph[i][2];

                link[u].add(new Edge(v, w));
            }

            for (int i = 1; i <= N; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            dist[from] = 0;
        }

        public void dijkstra(int start) {
            queue.add(new Node(start, 0));
            while (!queue.isEmpty()) {
                Node u = queue.poll();
                int vertexU = u.getVertex();
                if (visited[vertexU]) {
                    continue;
                }
                visited[vertexU] = true;
                for (Edge v : link[vertexU]) {
                    int vertexV = v.getVertex();
                    int weight = v.getWeight();
                    if (dist[vertexV] > dist[vertexU] + weight) {
                        dist[vertexV] = dist[vertexU] + weight;
                        queue.add(new Node(vertexV, dist[vertexV]));
                    }
                }
            }
        }

        public int getLeastCostTo(int to) {
            return dist[to];
        }
    }

    static class Edge {
        private final int vertex;
        private final int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }
    }

    static class Node implements Comparable<Node> {
        private final int vertex;
        private final int dist;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.dist = weight;
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

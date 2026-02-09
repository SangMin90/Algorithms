package ddongman.algorithms.doit.graph.dijkstra;

import java.util.*;
import java.util.stream.IntStream;

public class Dijkstra {

    private List<Edge>[] link;
    private int[] dist;
    private PriorityQueue<Node> queue;
    private boolean[] visited;

    public Object[] solution(int V, int E, int start, int[][] graph) {
        init(V, start, graph);

        return dijkstra(start);
    }

    private void init(int V, int start, int[][] graph) {

        link = new List[V + 1];
        dist = new int[V + 1];
        queue = new PriorityQueue<>();
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            link[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        dist[start] = 0;

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            link[u].add(new Edge(v, w));
        }
    }

    private Object[] dijkstra(int start) {
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node u = queue.poll();
            int uVertex = u.getVertex();
            if (visited[uVertex]) {
                continue;
            }
            visited[uVertex] = true;
            for (int i = 0; i < link[uVertex].size(); i++) {
                Edge edge = link[uVertex].get(i);
                int vVertex = edge.getVertex();
                int weight = edge.getWeight();

                if (dist[vVertex] > dist[uVertex] + weight) {
                    dist[vVertex] = dist[uVertex] + weight;
                    queue.add(new Node(vVertex, dist[vVertex]));
                }
            }
        }

        return IntStream.range(1, dist.length)
                .mapToObj(i -> {
                    if (!visited[i]) {
                        return "INF";
                    }
                    return dist[i];
                })
                .toArray();
    }

    static class Edge implements Comparable<Edge> {
        private final int vertex;
        private final int weight;

        public Edge(int number, int weight) {
            this.vertex = number;
            this.weight = weight;
        }

        public int getVertex() {
            return vertex;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(getWeight(), o.getWeight());
        }
    }

    static class Node implements Comparable<Node> {
        private final int vertex;
        private final int dist;

        public Node(int number, int dist) {
            this.vertex = number;
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

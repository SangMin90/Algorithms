package ddongman.algorithms.doit.graph;

import java.util.*;

import static ddongman.algorithms.doit.graph.BiPartite.Part.*;
import static ddongman.algorithms.doit.graph.BiPartite.YN.NO;
import static ddongman.algorithms.doit.graph.BiPartite.YN.YES;

public class BiPartite {
    private List<Integer>[] adjLink;
    private Part[] parts;
    private int[] visited;
    private Deque<Integer> queue;

    public YN solution(int V, Edge[] graph) {
        return isBipartite(V, graph);
    }

    public YN isBipartite(int V, Edge[] graph) {
        init(V, graph);

        visited[0] = 1;
        parts[0] = LEFT;
        queue.addLast(0);

        while (!queue.isEmpty()) {
            int u = queue.pop();
            List<Integer> linkOfU = adjLink[u];

            for (int v : linkOfU) {
                if (visited[v] == 0) {
                    parts[v] = Part.getOtherPart(parts[u]);
                    visited[v] = 1;
                    queue.addLast(v);
                } else {
                    if (parts[v].equals(parts[u])) {
                        return NO;
                    }
                }
            }
        }

        return YES;
    }

    public void init(int V, Edge[] graph) {
        adjLink = new List[V];
        parts = new Part[V];
        visited = new int[V];
        queue = new LinkedList<>();

        for (int i = 0; i < adjLink.length; i++) {
            adjLink[i] = new LinkedList<>();
        }

        for (Edge edge: graph) {
            int nodeA = edge.getNodeA() - 1;
            int nodeB = edge.getNodeB() - 1;
            adjLink[nodeA].add(nodeB);
            adjLink[nodeB].add(nodeA);
        }
    }

    static class Edge {
        private final int nodeA;
        private final int nodeB;

        public Edge(int nodeA, int nodeB) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }
    }

    enum Part {
        LEFT, RIGHT;

        public static Part getOtherPart(Part part) {
            return Arrays.stream(values())
                    .filter(value -> !value.equals(part))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("No other part found"));
        }
    }

    enum YN {
        YES, NO
    }
}

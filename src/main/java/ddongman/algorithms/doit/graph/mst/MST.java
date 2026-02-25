package ddongman.algorithms.doit.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MST {

    private List<Edge> graph;
    private UnionFind unionFind;

    public long solution(int V, int E, int[][] edges) {
        init(V, edges);

        List<Edge> mst = kruskal(V);

        return mst.stream().mapToLong(Edge::getWeight).sum();
    }

    private void init(int V, int[][] edges) {
        graph = new ArrayList<>();

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            int weight = edge[2];
            graph.add(new Edge(n1, n2, weight));
        }

        unionFind = new UnionFind(V);
    }

    private List<Edge> kruskal(int V) {

        Collections.sort(graph);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : graph) {
            int n1 = edge.getN1();
            int n2 = edge.getN2();

            if (unionFind.isSameUnion(n1, n2)) {
                continue;
            }

            unionFind.union(n1, n2);
            mst.add(new Edge(n1, n2, edge.getWeight()));

            if (mst.size() == V - 1) {
                break;
            }
        }

        return mst;
    }

    static class Edge implements Comparable<Edge> {

        private final int n1;
        private final int n2;
        private final int weight;

        public Edge(int n1, int n2, int weight) {
            this.n1 = n1;
            this.n2 = n2;
            this.weight = weight;
        }

        public int getN1() {
            return n1;
        }

        public int getN2() {
            return n2;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static class UnionFind {

        private final int[] root;

        public UnionFind(int V) {
            this.root = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                root[i] = i;
            }
        }

        public void union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            root[rootB] = rootA;
        }

        public int find(int a) {
            if (root[a] != a) {
                root[a] = find(root[a]);
            }

            return root[a];
        }

        public boolean isSameUnion(int a, int b) {
            return find(a) == find(b);
        }
    }
}

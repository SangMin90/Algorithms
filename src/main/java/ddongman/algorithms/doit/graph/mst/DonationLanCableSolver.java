package ddongman.algorithms.doit.graph.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DonationLanCableSolver {

    private static final char ZERO = '0';

    public int solution(int N, char[][] charGraph) {
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (charGraph[i][j] == ZERO) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = Alphabet.toWeight(charGraph[i][j]);
            }
        }

        UnionFind unionFind = new UnionFind(N);
        MST mst = new MST(unionFind, graph, N);

        List<Edge> edges = mst.kruskal(N);

        if (edges.isEmpty()) {
            return -1;
        }

        if (N == 1) {
            return edges.getFirst().getWeight();
        }

        return calculateTotalLenOfLanCable(graph) -
                edges.stream().mapToInt(Edge::getWeight).sum();
    }

    private int calculateTotalLenOfLanCable(int[][] graph) {
        int sum = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                sum += graph[i][j];
            }
        }

        return sum;
    }

    static class MST {

        private List<Edge> edges = new ArrayList<>();
        private final UnionFind unionFind;

        public MST(UnionFind unionFind, int[][] graph, int N) {
            this.unionFind = unionFind;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    edges.add(new Edge(i, j, graph[i][j]));
                }
            }
        }

        public List<Edge> kruskal(int N) {

            List<Edge> mst = new ArrayList<>();

            if (N == 1) {
                Edge edge = edges.getFirst();
                return List.of(new Edge(edge.getFrom(), edge.getTo(), edge.getWeight()));
            }

            Collections.sort(edges);

            for (Edge edge : edges) {
                int from = edge.getFrom();
                int to = edge.getTo();
                int weight = edge.getWeight();

                if (unionFind.isSameUnion(from, to)) {
                    continue;
                }

                if (weight != 0) {
                    mst.add(new Edge(from, to, weight));
                    unionFind.union(from, to);
                }

                if (mst.size() == N - 1) {
                    break;
                }
            }

            return mst.size() == N - 1 ? mst : List.of();
        }
    }

    static class UnionFind {

        private final int[] parent;

        UnionFind(int N) {

            this.parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
        }

        public void union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return;
            }

            parent[rootB] = rootA;
        }

        public int find(int a) {

            if (parent[a] != a) {
                parent[a] = find(parent[a]);
            }

            return parent[a];
        }

        public boolean isSameUnion(int a, int b) {
            return find(a) == find(b);
        }
    }

    static class Edge implements Comparable<Edge> {

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


        @Override
        public int compareTo(Edge o) {
            return Integer.compare(getWeight(), o.getWeight());
        }
    }

    enum Alphabet {
        UPPERCASE(27, 'A'),
        LOWERCASE(1, 'a');

        private final int startValue;
        private final char baseChar;

        Alphabet(int startValue, char baseChar) {
            this.startValue = startValue;
            this.baseChar = baseChar;
        }

        public int convert(char c) {
            return startValue + (c - baseChar);
        }

        public static int toWeight(char c) {
            if (Character.isUpperCase(c)) {
                return UPPERCASE.convert(c);
            }

            if (Character.isLowerCase(c)) {
                return LOWERCASE.convert(c);
            }

            throw new IllegalArgumentException("Illegal character: " + c);
        }
    }
}

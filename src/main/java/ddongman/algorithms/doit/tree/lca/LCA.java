package ddongman.algorithms.doit.tree.lca;

import java.util.*;
import java.util.stream.IntStream;

public class LCA {

    private static int ROOT = 1;
    private Node[] graph;
    private int[][] parents;

    public int[] solution(int N, int[][] edges, int M, int[][] queries) {

        build(N, edges);

        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int[] query = queries[i];
            result[i] = lca(query[0], query[1]);
        }

        return result;
    }

    private void build(int N, int[][] edges) {
        buildTree(N, edges);
        buildSparseTable(N);
    }

    private void buildTree(int N, int[][] edges) {
        List<Integer>[] adj = new ArrayList[N + 1];

        graph = new Node[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int n1 = edge[0];
            int n2 = edge[1];

            adj[n1].add(n2);
            adj[n2].add(n1);
        }

        Deque<Integer> queue = new ArrayDeque<>();

        graph[ROOT] = new Node(0, 1);
        queue.add(ROOT);
        while (!queue.isEmpty()) {
            int parent = queue.poll();

            for (int child : adj[parent]) {
                if (graph[child] == null) {
                    int depth = graph[parent].getDepth() + 1;
                    graph[child] = new Node(parent, depth);
                    queue.add(child);
                }
            }
        }
    }

    private void buildSparseTable(int N) {
        int maxDepth = IntStream.rangeClosed(1, N)
                .map(i -> graph[i].getDepth())
                .max()
                .orElse(1);

        int maxPower = log2(maxDepth);
        parents = new int[maxPower + 1][N + 1];

        for (int i = 0; i <= maxPower; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 0) {
                    parents[i][j] = graph[j].getParent();
                } else {
                    parents[i][j] = parents[i - 1][parents[i - 1][j]];
                }
            }
        }
    }

    private int lca(int a, int b) {

        if (graph[a].getDepth() > graph[b].getDepth()) {
            int temp = b;
            b = a;
            a = temp;
        }

        int diff = graph[b].getDepth() - graph[a].getDepth();
        b = getKthAncestor(b, diff);

        return findLCAFromSameDepth(a, b);
    }

    private int findLCAFromSameDepth(int a, int b) {

        int K = log2(graph[a].getDepth() - 1);
        for (int k = K; k >= 0; k--) {
            if (parents[k][a] != parents[k][b]) {
                a = parents[k][a];
                b = parents[k][b];
            }
        }

        return a == b ? a : parents[0][a];
    }

    private int getKthAncestor(int b, int diff) {
        while (diff > 0) {
            int K = log2(diff);
            b = parents[K][b];

            diff -= 1 << K;
        }

        return b;
    }

    private int log2(int num) {
        return 31 - Integer.numberOfLeadingZeros(num);
    }

    static class Node {

        private final int parent;
        private final int depth;

        public Node(int parent, int depth) {
            this.parent = parent;
            this.depth = depth;
        }

        public int getParent() {
            return parent;
        }

        public int getDepth() {
            return depth;
        }

    }
}

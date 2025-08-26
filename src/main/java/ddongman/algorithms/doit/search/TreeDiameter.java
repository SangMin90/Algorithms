package ddongman.algorithms.doit.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TreeDiameter {
    private boolean[] visited;
    private Queue<Edge>[] link;
    private Queue<Integer> queue;
    private int[][] result;

    public int solution(int n, int[][] edges) throws Exception {
        init(n, edges);
        int initNode = 1;

        // 트리 노드 찾기
        dfs(initNode);
        int treeNode = findTreeNode(initNode);

        init(n, edges);

        // 트리 지름 찾기
        dfs(treeNode);
        return findTreeDiamter(treeNode);
    }

    private void init(int n, int[][] edges) {
        visited = new boolean[n + 1];

        link = new Queue[n + 1];
        queue = new LinkedList<>();

        for (int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            link[parent] = new LinkedList<>();
            for (int j = 1; j < edges[i].length; j += 2) {
                if (edges[i][j] == -1) {
                    break;
                }
                link[parent].add(new Edge(edges[i][j], edges[i][j + 1]));
            }
        }

        result = new int[n + 1][n + 1];
    }

    private void initVisited(int n) {
        visited = new boolean[n + 1];
    }

    private void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer polledNode = queue.poll();
            while (!link[polledNode].isEmpty()) {
                Edge polledEdge = link[polledNode].poll();
                if (!visited[polledEdge.getNode()]) {
                    visited[polledEdge.getNode()] = true;
                    queue.add(polledEdge.getNode());
                    result[node][polledEdge.getNode()] = result[node][polledNode] + polledEdge.getLength();
                }
            }
        }
    }

    private int findTreeNode(int node) {
        int max = 0;
        int treeNode = 0;
        for (int i = 0; i < result[node].length; i++) {
            if (max < result[node][i]) {
                max = result[node][i];
                treeNode = i;
            }
        }
        return treeNode;
    }

    private int findTreeDiamter(int treeNode) {
        return Arrays.stream(result[treeNode])
                .max()
                .getAsInt();
    }

    private class Edge {
        private final int node;
        private final int length;

        public Edge(int node, int length) {
            this.node = node;
            this.length = length;
        }

        public int getNode() {
            return node;
        }

        public int getLength() {
            return length;
        }
    }
}

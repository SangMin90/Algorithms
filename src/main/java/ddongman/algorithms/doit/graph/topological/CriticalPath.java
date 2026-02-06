package ddongman.algorithms.doit.graph.topological;

import java.util.*;

public class CriticalPath {

    public int[] solution(int n, int m, int[][] edges, int start, int end) {
        TopologicalSort topologicalSort = new TopologicalSort(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            topologicalSort.addEdge(u, v);
            topologicalSort.setDistance(v, u, w);
        }

        topologicalSort.sort();

        int time = topologicalSort.getMaxCriticalPath(end);
        int count = topologicalSort.countCriticalEdges(end);

        return new int[]{time, count};
    }

    static class TopologicalSort {
        private final List<Integer>[] link;
        private final int[] inDegree;
        private final int[][] dist;
        private final Queue<Integer> queue;
        private final List<Integer> sorted;
        private final int[] cp;
        private final List<Integer>[] reverseLink;
        private final boolean[] visited;

        public TopologicalSort(int n) {
            link = new List[n + 1];
            reverseLink = new List[n + 1];
            inDegree = new int[n + 1];
            dist = new int[n + 1][n + 1];
            queue = new LinkedList<>();
            sorted = new ArrayList<>();
            cp = new int[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i < link.length; i++) {
                link[i] = new ArrayList<>();
                reverseLink[i] = new ArrayList<>();
            }
        }

        public void addEdge(int from, int to) {
            link[from].add(to);
            inDegree[to]++;

            reverseLink[to].add(from);
        }

        public void setDistance(int u, int v, int w) {
            dist[u][v] = w;
            dist[v][u] = w;
        }

        public void calculateCriticalPath(int u, int v, int w) {
            cp[v] = Math.max(cp[v], cp[u] + w);
        }

        public List<Integer> sort() {
            for (int i = 1; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer from = queue.poll();
                sorted.add(from);
                for (int to : link[from]) {
                    if (--inDegree[to] == 0) {
                        queue.add(to);
                    }
                    calculateCriticalPath(from, to, dist[from][to]);
                }
            }

            return sorted;
        }

        public int countCriticalEdges(int end) {

            int totalCount = 0;

            queue.add(end);
            while (!queue.isEmpty()) {
                Integer to = queue.poll();

                for (Integer from: reverseLink[to]) {
                    if (cp[to] == (cp[from] + dist[from][to])) {
                        if (!visited[from]) {
                            queue.add(from);
                            visited[from] = true;
                        }

                        totalCount++;
                    }
                }
            }

            return totalCount;
        }

        public int getMaxCriticalPath(int end) {
            return cp[end];
        }
    }
}

package ddongman.algorithms.doit.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StudentOrdering {

    public int[] solution(int N, int M, int[][] orders) {
        TopologicalSort topologicalSort = new TopologicalSort(N);

        for (int[] order : orders) {
            int from = order[0];
            int to = order[1];
            topologicalSort.addEdge(from, to);
        }

        return topologicalSort.sort()
                .stream().mapToInt(Integer::intValue).toArray();
    }

    static class TopologicalSort {
        private List<Integer>[] link;
        private int[] inDegree;
        private List<Integer> sorted;
        private boolean[] visited;
        private Queue<Integer> queue;

        public TopologicalSort(int N) {
            link = new List[N + 1];
            inDegree = new int[N + 1];
            sorted = new ArrayList<>();
            visited = new boolean[N + 1];
            queue = new LinkedList<>();

            for (int i = 0; i <= N; i++) {
                link[i] = new ArrayList<>();
            }
        }

        public void addEdge(int from, int to) {
            link[from].add(to);
            inDegree[to]++;
        }

        public List<Integer> sort() {
            for (int i = 1; i < inDegree.length ; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int from = queue.poll();
                visited[from] = true;
                sorted.add(from);
                for (int to : link[from]) {
                    if (--inDegree[to] == 0) {
                        queue.add(to);
                    }
                }
            }

            return sorted;
        }
    }
}

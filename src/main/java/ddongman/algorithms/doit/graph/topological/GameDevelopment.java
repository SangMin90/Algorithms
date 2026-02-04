package ddongman.algorithms.doit.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameDevelopment {

    public int[] solution(int N, int[][] graph) {
        TopologicalSort topologicalSort = new TopologicalSort(N);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                if (graph[i][j] != -1) {
                    topologicalSort.addEdge(graph[i][j], i + 1);
                }
            }
        }

        ConstructionTimeManager constructionTimeManager = new ConstructionTimeManager(N, topologicalSort);
        for (int i = 0; i < graph.length; i++) {
            constructionTimeManager.setConstructionTime(i + 1, graph[i][0]);
        }

        List<Integer> sorted = topologicalSort.sort();

        return constructionTimeManager.calculateCompletionTime(sorted);
    }

    static class ConstructionTimeManager {
        private final int[] constructionTime;
        private final int[] completionTime;

        private final TopologicalSort topologicalSort;

        public ConstructionTimeManager(int N, TopologicalSort topologicalSort) {
            constructionTime = new int[N + 1];
            completionTime = new int[N];
            this.topologicalSort = topologicalSort;
        }

        public void setConstructionTime(int i, int time) {
            constructionTime[i] = time;
        }

        public int[] calculateCompletionTime(List<Integer> sorted) {
            for (Integer ele: sorted) {
                completionTime[ele - 1] += constructionTime[ele];
                topologicalSort.nextOf(ele)
                        .forEach(e ->
                                completionTime[e - 1] =
                                        Math.max(
                                                completionTime[ele - 1],
                                                completionTime[e - 1]
                                        )
                );
            }

            return completionTime;
        }

    }

    static class TopologicalSort {
        private final List<Integer>[] link;
        private final int[] inDegree;
        private final Queue<Integer> queue;
        private final List<Integer> sorted;

        public TopologicalSort(int N) {
            link = new ArrayList[N + 1];
            inDegree = new int[N + 1];
            queue = new LinkedList<>();
            for (int i = 0; i <= N; i++) {
                link[i] = new ArrayList<>();
            }
            sorted = new ArrayList<>();
        }

        public void addEdge(int from, int to) {
            link[from].add(to);
            inDegree[to]++;
        }

        public List<Integer> sort() {
            for (int i = 1; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                Integer polled = queue.poll();
                sorted.add(polled);
                for (int to : link[polled]) {
                    if (--inDegree[to] == 0) {
                        queue.add(to);
                    }
                }
            }

            return sorted;
        }

        public List<Integer> nextOf(int ele) {
            return link[ele];
        }
    }
}

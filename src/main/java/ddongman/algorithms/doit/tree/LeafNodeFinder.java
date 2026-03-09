package ddongman.algorithms.doit.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

public class LeafNodeFinder {

    private List<Integer>[] graph;
    private boolean[] visited;
    private Queue<Integer> queue = new LinkedList<>();
    private int root;

    public int solution(int N, int[] parents, int targetNode) {

        init(N, parents);

        root = findRoot(parents);

        return findLeafNodeCount(targetNode);
    }

    private int findLeafNodeCount(int targetNode) {
        int leafNodeCount = 0;

        if (root != targetNode) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Integer parent = queue.poll();
            visited[parent] = true;

            int size = queue.size();

            for (Integer child : graph[parent]) {
                if (child != targetNode && !visited[child]) {
                    queue.add(child);
                }
            }

            if (queue.size() == size) {
                leafNodeCount++;
            }
        }

        return leafNodeCount;
    }

    private void init(int N, int[] parents) {
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            if (parents[i] != -1) {
                graph[parents[i]].add(i);
            }
        }
    }

    private int findRoot(int[] parents) {
        return IntStream
                .range(0, parents.length)
                .filter(i -> parents[i] == -1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("루트가 존재하지 않습니다."));

    }
}

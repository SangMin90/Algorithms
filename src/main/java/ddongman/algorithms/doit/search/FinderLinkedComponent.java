package ddongman.algorithms.doit.search;

import java.util.ArrayList;
import java.util.List;

public class FinderLinkedComponent {
    private boolean[] visited;
    private List<Integer>[] link;

    public int solution(int n, int m, int[][] edges) {
        init(n, m, edges);

        int linkedComponentCount = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                linkedComponentCount++;
            }
        }

        return linkedComponentCount;
    }

    private void init(int n, int m, int[][] edges) {
        // 변수 초기화
        visited = new boolean[n + 1];
        link = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            link[edges[i][0]].add(edges[i][1]);
            link[edges[i][1]].add(edges[i][0]);
        }
    }

    private void dfs(int i) {
        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (int j = 0; j < link[i].size(); j++) {
            int k = link[i].get(j);
            dfs(k);
        }
    }
}

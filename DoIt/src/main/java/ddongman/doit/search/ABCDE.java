package ddongman.doit.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ABCDE {
    private boolean[] visited;
    private int[] count;
    private List<Integer>[] link;

    public int solution(int n, int m, int[][] relation) {
        init(n, m, relation);

        for (int i = 0; i < n; i++) {
            dfs(i, 1);
            reset(n);
        }

        return Arrays.stream(count)
                .filter(i -> i > 0)
                .findFirst()
                .isPresent() ? 1 : 0;
    }

    private void init(int n, int m, int[][] edges) {
        // 변수 초기화
        visited = new boolean[n];
        link = new ArrayList[n];
        count = new int[n];

        for (int i = 0; i < n; i++) {
            link[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            link[edges[i][0]].add(edges[i][1]);
            link[edges[i][1]].add(edges[i][0]);
        }
    }

    private void dfs(int num, int cnt) {
        if (!visited[num] && cnt == 5) {
            count[num] += 1;
            return;
        }

        if (visited[num]) {
            return;
        }

        visited[num] = true;

        for (int i = 0; i < link[num].size(); i++) {
            dfs(link[num].get(i), cnt + 1);
        }
    }

    private void reset(int n) {
        visited = new boolean[n];
    }
}

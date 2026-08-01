package ddongman.algorithms.leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    private List<List<Integer>> result = new ArrayList<>();
    private boolean[] visited;

    public List<List<Integer>> combine(int n, int k) {

        visited = new boolean[n + 1];

//        backtracking(1, n, k, new ArrayList<>());
//        backtracking2(1, n, k, new ArrayList<>());
        backtracking3(1, n, k, new ArrayList<>());

        return result;
    }

    private void backtracking(int i, int n, int k, List<Integer> path) {

        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num = i; num <= n; num++) {
            if (!visited[num]) {
                path.add(num);
                visited[num] = true;
                backtracking(num + 1, n, k, path);
                visited[num] = false;
                path.removeLast();
            }
        }
    }

    private void backtracking2(int i, int n, int k, List<Integer> path) {

        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num = i; num <= n; num++) {
            if ((n - num) + 1 >= k) {
                path.add(num);
                backtracking2(num + 1, n, k - 1, path);
                path.removeLast();
            }
        }
    }

    private void backtracking3(int i, int n, int k, List<Integer> path) {

        if (k == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int num = i; num <= n - k + 1; num++) {
            path.add(num);
            backtracking3(num + 1, n, k - 1, path);
            path.removeLast();
        }
    }
}
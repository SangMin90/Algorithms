package ddongman.algorithms.leet.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    private int[][] min;
    private int N;

    public int snakesAndLadders(int[][] board) {
        N = board.length;
        min = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(1, 0, board, false);

        int minPath = N % 2 == 0 ? min[0][0] :min[0][N - 1];
        return minPath == Integer.MAX_VALUE ? -1 : minPath;
    }

    public int snakesAndLaddersWithBfs(int[][] board) {

        int N = board.length;
        int[] min = new int[N * N + 1];
        Arrays.fill(min, -1);

        Queue<Integer> queue = new LinkedList<>();

        min[1] = 0;
        queue.offer(1);
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i <= 6 && curr + i <= N * N; i++) {

                int next = curr + i;
                int x = (N - 1) - (next - 1) / N;
                int y = ((next - 1) / N) % 2 == 0 ?
                    (next - 1) % N : (N - 1) - (next - 1) % N;

                next = board[x][y] != -1 ? board[x][y] : next;

                if (next == N * N) {
                    return min[curr] + 1;
                }

                if (min[next] == -1) {
                    min[next] = min[curr] + 1;
                    queue.offer(next);
                }
            }
        }

        return min[N * N];
    }

    private void bfs(int start, int count, int[][] board, boolean usedShortcut) {

        if (start >= N * N) {
            int y = N % 2 == 0 ? 0 : N - 1;

            min[0][y] = Math.min(min[0][y], count);

            return;
        }

        Point curr = convertToPoint(start);

        if (board[curr.x][curr.y] != -1 && !usedShortcut) {
            bfs(board[curr.x][curr.y], count, board, true);
            return;
        }

        if (count >= min[curr.x][curr.y]) {
            return;
        }

        min[curr.x][curr.y] = count;

        usedShortcut = false;
        int nextCount = count + 1;

        bfs(start + 1, nextCount, board, usedShortcut);
        bfs(start + 2, nextCount, board, usedShortcut);
        bfs(start + 3, nextCount, board, usedShortcut);
        bfs(start + 4, nextCount, board, usedShortcut);
        bfs(start + 5, nextCount, board, usedShortcut);
        bfs(start + 6, nextCount, board, usedShortcut);
    }

    private Point convertToPoint(int num) {
        int x = (N - 1) - ((num - 1) / N);
        int y = (N % 2 == 1 && x % 2 == 0 || N % 2 == 0 && x % 2 == 1) ? (num - 1) % N : (N - 1) - (num - 1) % N;
        return new Point(x, y);
    }

    record Point(int x, int y) {
    }
}

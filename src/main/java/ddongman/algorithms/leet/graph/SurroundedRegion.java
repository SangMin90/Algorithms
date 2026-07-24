package ddongman.algorithms.leet.graph;

import java.util.ArrayList;
import java.util.List;

public class SurroundedRegion {

    private List<Region> regions = new ArrayList<>();
    private boolean[][] visited;

    private int M;
    private int N;

    public char[][] solve(char[][] board) {

        M = board.length;
        N = board[0].length;

        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O') {
                    Region region = new Region();
                    markRegion(i, j, region, board);

                    regions.add(region);
                }
            }
        }

        regions.stream()
            .filter(region -> !region.isOnEdge(0, 0, M - 1, N - 1))
            .forEach(region -> {
                for (Point point : region.points) {
                    board[point.row][point.col] = 'X';
                }
            });

        return board;
    }

    private void markRegion(int row, int col, Region region, char[][] board) {

        if (row < 0 || row >= M || col < 0 || col >= N) {
            return;
        }

        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        if (board[row][col] == 'O') {
            region.addPoint(new Point(row, col));

            markRegion(row + 1, col, region, board);
            markRegion(row, col + 1, region, board);
            markRegion(row - 1, col, region, board);
            markRegion(row, col - 1, region, board);
        }
    }

    record Point(int row, int col) {}
    static class Region {
        private final List<Point> points = new ArrayList<>();

        public Region() {}

        public void addPoint(Point point) {
            points.add(point);
        }

        public boolean isOnEdge(int minRow, int minCol, int maxRow, int maxCol) {
            return points.stream().anyMatch(point ->
                point.row == minRow || point.col == minCol || point.row == maxRow || point.col == maxCol
            );
        }
    }

    public char[][] solve2(char[][] board) {
        M = board.length;
        N = board[0].length;

        for (int i = 0; i < M; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }
        }

        for (int i = 0; i < N; i++) {
            if (board[0][i] == 'O') {
                dfs(0, i, board);
            }
        }

        for (int i = 0; i < M; i++) {
            if (board[i][N - 1] == 'O') {
                dfs(i, N - 1, board);
            }
        }

        for (int i = 0; i < N; i++) {
            if (board[M - 1][i] == 'O') {
                dfs(M - 1, i, board);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 'S') {
                    board[i][j] = 'X';
                } else {
                    board[i][j] = 'O';
                }
            }
        }

        return board;
    }

    private void dfs(int row, int col, char[][] board) {

        if (row < 0 || row >= N || col < 0 || col >= M) {
            return;
        }

        if (board[row][col] == 'O') {
            board[row][col] = 'S';
            dfs(row + 1, col, board);
            dfs(row , col + 1, board);
            dfs(row - 1, col, board);
            dfs(row, col - 1, board);
        }
    }
}

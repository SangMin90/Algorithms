package ddongman.algorithms.leet.graph;

public class IslandCounter {

    private int m;
    private int n;
    private int count;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] marked = new boolean[m][n];

        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    connectIsland(i, j, grid, marked);
                    num++;
                }
            }
        }

        return num;
    }

    private void connectIsland(int x, int y, char[][] grid, boolean[][] marked) {

        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0' || marked[x][y]) {
            return;
        }

        grid[x][y] = '0';

        connectIsland(x + 1, y, grid, marked);
        connectIsland(x - 1, y, grid, marked);
        connectIsland(x, y - 1, grid, marked);
        connectIsland(x, y + 1, grid, marked);
    }

    public int numIslands2(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    connectIsland2(i, j, grid);
                    num++;
                }
            }
        }

        return num;
    }

    private void connectIsland2(int x, int y, char[][] grid) {

        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';

        connectIsland2(x + 1, y, grid);
        connectIsland2(x - 1, y, grid);
        connectIsland2(x, y - 1, grid);
        connectIsland2(x, y + 1, grid);
    }

    public int numIslands3(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for (int row = 0; row < m; row++) {
            checkRow(row, grid);
        }

        return count;
    }

    private void checkRow(int row, char[][] grid) {
        final char[] cols = grid[row];

        for (int col = 0; col < n; col++) {
            if (cols[col] == '1') {
                connect(row, col, grid);
                count++;
            }
        }
    }

    private void connect(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        connect(row + 1, col, grid);
        connect(row - 1, col, grid);
        connect(row, col + 1, grid);
        connect(row, col - 1, grid);
    }
}

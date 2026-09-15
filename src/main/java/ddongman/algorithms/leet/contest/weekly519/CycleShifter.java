package ddongman.algorithms.leet.contest.weekly519;

public class CycleShifter {

    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {

        for (int i = 0; i < rowShift.length; i++) {

            int k = rowShift[i];

            while (k-- > 0) {
                rowShift(grid, i);
            }
        }

        for (int i = 0; i < colShift.length; i++) {

            int k = colShift[i];

            while (k-- > 0) {
                colShift(grid, i);
            }
        }

        return grid;
    }

    private void rowShift(int[][] grid, int row) {

        int n = grid.length;
        for (int i = 0; i < n - 1; i++) {
            int temp = grid[row][i];
            grid[row][i] = grid[row][(n + i - 1) % n];
            grid[row][(n + i - 1) % n] = temp;
        }
    }

    private void colShift(int[][] grid, int col) {

        int n = grid.length;
        for (int i = 0; i < n - 1; i++) {
            int temp = grid[i][col];
            grid[i][col] = grid[(n + i - 1) % n][col];
            grid[(n + i - 1) % n][col] = temp;
        }
    }

}

package ddongman.algorithms.leet.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        int m =  matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (true) {
            visited[i][j] = true;
            result.add(matrix[i][j]);
            if ((j + 1 < n && !visited[i][j + 1]) && (i - 1 < 0 || visited[i - 1][j])) {
                j++;
                continue;
            }

            if (i + 1 < m && !visited[i + 1][j]) {
                i++;
                continue;
            }

            if (j - 1 >= 0 && !visited[i][j - 1]) {
                j--;
                continue;
            }

            if (i - 1 >= 0 && !visited[i - 1][j]) {
                i--;
                continue;
            }

            break;
        }

        return result;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {

            // left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // right to left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}

package ddongman.algorithms.leet.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MatrixZeroes {

    public int[][] setZeroes(int[][] matrix) {

        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for (Integer row : rowSet) {
            Arrays.fill(matrix[row], 0);
        }

        for (Integer col : colSet) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }

        return matrix;
    }

    public int[][] setZeroesV2(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        boolean originRow = false;
        boolean originCol = false;

        for (int row = 0; row < m; row++) {
            if (matrix[row][0] == 0) {
                originCol = true;
                break;
            }
        }

        for (int col = 0; col < n; col++) {
            if (matrix[0][col] == 0) {
                originRow = true;
                break;
            }
        }

        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < m; row++) {
            if (matrix[row][0] == 0) {
                for (int col = 1; col < n; col++) {
                    matrix[row][col] = 0;
                }
            }
        }

        for (int col = 1; col < n; col++) {
            if (matrix[0][col] == 0) {
                for (int row = 1; row < m; row++) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (originRow) {
            Arrays.fill(matrix[0], 0);
        }

        if (originCol) {
            for (int row = 0; row < m; row++) {
                matrix[row][0] = 0;
            }
        }

        return matrix;
    }
}

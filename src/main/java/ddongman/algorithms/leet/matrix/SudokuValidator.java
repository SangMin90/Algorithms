package ddongman.algorithms.leet.matrix;

import java.util.Arrays;

public class SudokuValidator {

    public boolean isValidSudoku(char[][] board) {

        int N = board.length;
        boolean[] visitedRow = new boolean[N];
        boolean[] visitedColumn = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char rowChar = board[i][j];
                if (isDigit(rowChar)) {

                    int idx = (rowChar - '0') - 1;
                    if (visitedRow[idx]) {
                        return false;
                    }

                    visitedRow[idx] = true;
                }

                char colChar = board[j][i];
                if (isDigit(colChar)) {

                    int idx = (colChar - '0') - 1;
                    if (visitedColumn[idx]) {
                        return false;
                    }

                    visitedColumn[idx] = true;
                }
            }

            Arrays.fill(visitedRow, false);
            Arrays.fill(visitedColumn, false);
        }

        for (int i = 0; i < N; i += 3) {
            for (int j = 0; j < N; j += 3) {
                if (!isValidSubMatrix(i, j, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidSubMatrix(int i, int j, char[][] board) {

        boolean[] visited = new boolean[9];

        for (int row = i; row < i + 3; row++) {
            for (int col = j; col < j + 3; col++) {
                char c = board[row][col];
                if (isDigit(c)) {

                    int idx = (c - '0') - 1;
                    if (visited[idx]) {
                        return false;
                    }

                    visited[idx] = true;
                }
            }
        }

        return true;
    }

    private boolean isDigit(char c) {

        return (c >= '1' && c <= '9');
    }

    public boolean isValidSudokuWithBitmask(char[][] board) {

        int N = board.length;
        int[] rowMask = new int[N];
        int[] colMask = new int[N];
        int[] subBoxMask = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                int bit = 1 << (c - '0');
                int subBox = (i / 3) * 3 + (j / 3);

                if ((rowMask[i] & bit) != 0 ||
                        (colMask[j] & bit) != 0 ||
                        (subBoxMask[subBox] & bit) != 0
                ) {
                    return false;
                }

                rowMask[i] |= bit;
                colMask[j] |= bit;
                subBoxMask[subBox] |= bit;
            }
        }

        return true;
    }
}

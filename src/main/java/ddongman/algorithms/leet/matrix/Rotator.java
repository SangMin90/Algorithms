package ddongman.algorithms.leet.matrix;

public class Rotator {

    final int rotateCount = 3;

    public void rotate(int[][] matrix) {

        for (int borderLen = matrix.length; borderLen >= 1; borderLen -= 2) {
            rotateBorder(matrix, borderLen);
        }
    }

    private void rotateBorder(int[][] matrix, int borderLen) {

        int startX = (matrix.length - borderLen) / 2;
        for (int startY = startX; startY < startX + borderLen - 1; startY++) {
            int cnt = 0;

            int x = startY;
            int y = (matrix.length - 1) - startX;

            while (cnt++ < rotateCount) {
                int temp = matrix[x][y];
                matrix[x][y] = matrix[startX][startY];
                matrix[startX][startY] = temp;

                int tempIndex = x;
                x = y;
                y = (matrix.length - 1) - tempIndex;
            }
        }
    }

    public void rotate2(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = temp;
            }
        }
    }
}

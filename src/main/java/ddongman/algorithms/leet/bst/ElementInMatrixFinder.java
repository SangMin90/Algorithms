package ddongman.algorithms.leet.bst;

public class ElementInMatrixFinder {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = binarySearch(matrix, 0, matrix.length - 1, target);
        if (row == -1) {
            return false;
        }

        return binarySearch(matrix, 0, matrix[row].length - 1, target, row);
    }

    private int binarySearch(int[][] matrix, int start, int end, int target) {

        if (start > end) {
            return end;
        }

        int mid = start + (end - start) / 2;

        if (matrix[mid][0] == target) {
            return mid;
        } else if (matrix[mid][0] < target) {
            return binarySearch(matrix, mid + 1, end, target);
        } else {
            return binarySearch(matrix, start, mid - 1, target);
        }
    }

    private boolean binarySearch(int[][] matrix, int start, int end, int target, int row) {

        if (start > end) {
            return false;
        }

        int mid = start + (end - start) / 2;

        if (matrix[row][mid] == target) {
            return true;
        } else if (matrix[row][mid] < target) {
            return binarySearch(matrix, mid + 1, end, target, row);
        } else {
            return binarySearch(matrix, start, mid - 1, target, row);
        }
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = n * m - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int row = mid / m;
            int col = mid % m;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

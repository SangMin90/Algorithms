package ddongman.algorithms.leet.divideNConquer;

import ddongman.algorithms.leet.divideNConquer.domain.Node;

public class QuadTreeConstructor {

    public Node construct(int[][] grid) {

        return divide(grid, 0, 0, grid.length);
    }

    private Node divide(int[][] grid, int x, int y, int len) {

        if (len == 1) {
            return new Node(grid[x][y] == 1, true);
        }

        len = len / 2;
        Node topLeft = divide(grid, x, y, len);
        Node topRight = divide(grid, x, y + len, len);
        Node bottomLeft = divide(grid, x + len, y, len);
        Node bottomRight = divide(grid, x + len, y + len, len);

        if (topLeft.val == topRight.val && topRight.val == bottomLeft.val &&
            bottomLeft.val == bottomRight.val &&
            topLeft.isLeaf && topRight.isLeaf &&
            bottomRight.isLeaf && bottomLeft.isLeaf) {

            return new Node(topLeft.val, true);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}

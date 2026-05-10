package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;

public class TreeNodeCounter {

    private int count;

    public int countNodesWithDFS(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxDepth = findMaxDepth(root);

        if (maxDepth == 1) {
            return 1;
        }

        int maxDepthOnRightSide = findRightSideMaxDepth(root);

        if (maxDepth == maxDepthOnRightSide) {
            count += (1 << (maxDepth - 1)) / 2;
            dfs(root.getRight(), 2, maxDepth);
        } else {
            dfs(root.getLeft(), 2, maxDepth);
        }

        return (1 << (maxDepth - 1)) - 1 + count;
    }

    public int countNodesWithHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }

        return 1 + countNodesWithHeight(root.getLeft()) + countNodesWithHeight(root.getRight());
    }

    public int leftHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.getLeft();
        }

        return height;
    }

    public int rightHeight(TreeNode node) {

        int height = 0;

        while (node != null) {
            height++;
            node = node.getRight();
        }

        return height;
    }

    private int findMaxDepth(TreeNode root) {

        int maxDepth = 1;

        TreeNode left = root.getLeft();

        while (left != null) {
            maxDepth++;
            left = left.getLeft();
        }

        return maxDepth;
    }

    private int findRightSideMaxDepth(TreeNode root) {
        int maxDepthOnRight = 1;

        TreeNode node = root.getRight();

        while (node != null) {
            maxDepthOnRight++;
            node = node.getLeft();
        }

        return maxDepthOnRight;
    }

    private void dfs(TreeNode currentNode, int depth, int maxDepth) {

        if (currentNode == null) {
            return;
        }

        if (depth == maxDepth) {
            count++;
            return;
        }

        dfs(currentNode.getLeft(), depth + 1, maxDepth);
        dfs(currentNode.getRight(), depth + 1, maxDepth);
    }
}

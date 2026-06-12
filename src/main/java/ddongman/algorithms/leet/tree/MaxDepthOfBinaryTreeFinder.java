package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;

public class MaxDepthOfBinaryTreeFinder {

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int depth = 1;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return depth + Math.max(leftDepth, rightDepth);
    }
}

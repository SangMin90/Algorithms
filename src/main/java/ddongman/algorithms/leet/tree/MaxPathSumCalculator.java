package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;

public class MaxPathSumCalculator {

    private int max = -1001;

    public int calculate(TreeNode root) {

        maxSubsetSum(root);

        return max;
    }

    private int maxSubsetSum(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = Math.max(0, maxSubsetSum(node.getLeft()));
        int right = Math.max(0, maxSubsetSum(node.getRight()));

        max = Math.max(max, node.getVal() + left + right);

        return Math.max(
                node.getVal(),
                node.getVal() + Math.max(left, right)
        );
    }
}

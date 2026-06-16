package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {

    List<Integer> orderedNums = new ArrayList<>();

    Integer prev = null;
    int min = 100000;

    public int getMinimumDifference(TreeNode root) {

        inorderTreeWalk(root);

        int min = 100000;
        for (int i = 0; i < orderedNums.size() - 1; i++) {
            min = Math.min(min, Math.abs(orderedNums.get(i + 1) - orderedNums.get(i)));
        }

        return min;
    }

    private void inorderTreeWalk(TreeNode node) {

        if (node == null) {
            return;
        }

        inorderTreeWalk(node.left);
        orderedNums.add(node.val);
        inorderTreeWalk(node.right);
    }

    public int getMinimumDifference2(TreeNode root) {

        inorderTreeWalk2(root);

        return min;
    }

    private void inorderTreeWalk2(TreeNode node) {

        if (node == null) {
            return;
        }

        inorderTreeWalk2(node.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev - node.val));
        }
        prev = node.val;
        inorderTreeWalk2(node.right);
    }
}

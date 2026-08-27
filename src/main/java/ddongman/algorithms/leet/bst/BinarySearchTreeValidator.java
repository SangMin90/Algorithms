package ddongman.algorithms.leet.bst;

import com.sun.source.tree.Tree;
import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeValidator {

    private final long MIN = (long) Integer.MIN_VALUE - 1;
    private final long MAX = (long) Integer.MAX_VALUE + 1;

    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        long left = findMax(root.left);
        long right = findMin(root.right);

        if (left >= root.val || right <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    private long findMax(TreeNode node) {

        if (node == null) {
            return MIN;
        }

        return Math.max(node.val, Math.max(findMax(node.right), findMax(node.left)));
    }

    private long findMin(TreeNode node) {

        if (node == null) {
            return MAX;
        }

        return Math.min(node.val, Math.min(findMin(node.left), findMin(node.right)));
    }

    public boolean isValidBST2(TreeNode root) {

        return isValid(root, MIN, MAX);
    }

    private boolean isValid(TreeNode node, long min, long max) {

        if (node == null) {
            return true;
        }

        if (node.val > min && node.val < max) {
            return isValid(node.left, min, Math.min(node.val, max)) && isValid(node.right, Math.max(node.val, min), max);
        }

        return false;
    }

    private long prev;

    public boolean isValidBST3(TreeNode root) {

        prev = ((long) Integer.MIN_VALUE) - 1;
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {

        if (node == null) {
            return true;
        }

        if (!inorder(node.left)) {
            return false;
        }

        if (prev >= node.val) {
            return false;
        } else {
            prev = node.val;
        }

        if (!inorder(node.right)) {
            return false;
        }

        return true;
    }
}

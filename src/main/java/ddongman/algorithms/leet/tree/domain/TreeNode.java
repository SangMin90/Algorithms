package ddongman.algorithms.leet.tree.domain;

import java.util.Objects;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}

    public TreeNode(int val) { this.val = val; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TreeNode treeNode)) {
            return false;
        }
        return val == treeNode.val && Objects.equals(left, treeNode.left)
            && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }
}

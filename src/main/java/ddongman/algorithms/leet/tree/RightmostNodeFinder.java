package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightmostNodeFinder {

    Queue<Node> queue = new LinkedList<>();
    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        queue.add(Node.fromTreeNode(root, 0));
        while (!queue.isEmpty()) {

            Node poll = queue.poll();

            if (result.size() == poll.depth) {
                result.add(poll.val);
            } else {
                result.set(poll.depth, poll.val);
            }

            if (poll.left != null) {
                queue.add(Node.fromTreeNode(poll.left, poll.depth + 1));
            }

            if (poll.right != null) {
                queue.add(Node.fromTreeNode(poll.right, poll.depth + 1));
            }
        }

        return result;
    }

    static class Node extends TreeNode {
        int depth;

        public Node(TreeNode treeNode, int depth) {
            super(treeNode.val, treeNode.left, treeNode.right);
            this.depth = depth;
        }

        public static Node fromTreeNode(TreeNode treeNode, int depth) {
            return new Node(treeNode, depth);
        }
    }

    public List<Integer> rightSideView2(TreeNode root) {

        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(root.val);
        }

        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}

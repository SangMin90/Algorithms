package ddongman.algorithms.leet.bfs;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {

        final List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNodeLevel> queue = new ArrayDeque<>();

        queue.add(new TreeNodeLevel(root, 0));
        while (!queue.isEmpty()) {

            TreeNodeLevel polled = queue.poll();
            if (result.size() < polled.level + 1) {
                result.add(new ArrayList<>());
            }
            result.get(polled.level).add(polled.root().val);

            if (polled.root().left != null) {
                queue.add(new TreeNodeLevel(polled.root().left, polled.level + 1));
            }

            if (polled.root().right != null) {
                queue.add(new TreeNodeLevel(polled.root().right, polled.level + 1));
            }
        }

        return result;
    }

    record TreeNodeLevel(TreeNode root, int level) {}

    public List<List<Integer>> levelOrder2(TreeNode root) {
        final List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            result.add(new ArrayList<>());

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();

                result.getLast().add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }

    private final List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder3(TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        } else {
            dfs(root, 0);

            return result;
        }
    }

    private void dfs(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);

        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

package ddongman.algorithms.leet.bst;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.PriorityQueue;

public class KthSmallestElementFinder {

    PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    private int order;
    private int kthElement;

    public int kthSmallest(TreeNode root, int k) {

        search(root, k);

        while (!queue.isEmpty() && queue.size() != k) {
            queue.poll();
        }

        return queue.poll();
    }

    private void search(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        queue.add(node.val);
        if (queue.size() > k) {
            queue.poll();
        }

        search(node.left, k);
        search(node.right, k);
    }

    public int kthSmallest2(TreeNode root, int k) {

        inorder(root, k);

        return kthElement;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) {
            return;
        }

        inorder(node.left, k);
        if (++order == k) {
            kthElement = node.val;
            return;
        }
        inorder(node.right, k);
    }
}

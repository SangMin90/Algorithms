package ddongman.algorithms.leet.divideNConquer;

import ddongman.algorithms.leet.tree.domain.TreeNode;

public class SortedArrayToBstConverter {

    public TreeNode sortedArrayToBST(int[] nums) {

        return divideAndConquer(0, nums.length - 1, nums);
    }

    private TreeNode divideAndConquer(int start, int end, int[] nums) {

        if (start > end) {
            return null;
        }

        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);


        treeNode.left = divideAndConquer(start, mid - 1, nums);
        treeNode.right = divideAndConquer(mid + 1, end, nums);

        return treeNode;
    }
}

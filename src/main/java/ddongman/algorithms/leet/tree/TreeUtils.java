package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeUtils {

    private static final int MAX_DEPTH = 10000;
    private long[] sum;
    private long[] count;

    public List<Double> averageOfLevels(TreeNode root) {
        sum = new long[MAX_DEPTH];
        count = new long[MAX_DEPTH];

        summing(root, 0);

        List<Double> result = new ArrayList<>();
        int i = 0;
        while (count[i] > 0) {
            result.add((double) sum[i] / count[i]);
            i++;
        }

        return result;
    }

    private void summing(TreeNode parent, int depth) {

        if (parent == null) {
            return;
        }

        sum[depth] += parent.val;
        count[depth]++;

        summing(parent.left, depth + 1);
        summing(parent.right, depth + 1);
    }
}

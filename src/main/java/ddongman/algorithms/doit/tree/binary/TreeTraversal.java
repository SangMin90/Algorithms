package ddongman.algorithms.doit.tree.binary;

import java.util.HashMap;
import java.util.Map;

public class TreeTraversal {

    private static final String ROOT = "A";
    private static final String EMPTY = ".";

    private String[] tree = new String[67_108_864];
    private Map<String, Integer> indexes = new HashMap<>();

    public String[] solution(int N, String[][] edges) {

        init(edges);

        int rootIndex = indexes.get(ROOT);

        return new String[]{
                preOrder(rootIndex),
                inOrder(rootIndex),
                postOrder(rootIndex)
        };
    }

    private void init(String[][] edges) {

        int rootIndex = 1;
        tree[rootIndex] = ROOT;
        indexes.put(ROOT, rootIndex);

        for (String[] edge : edges) {
            String parent = edge[0];
            String left = edge[1];
            String right = edge[2];

            Integer parentIndex = indexes.get(parent);

            if (!EMPTY.equals(left)) {
                int leftIndex = parentIndex * 2;
                tree[leftIndex] = left;
                indexes.put(left, leftIndex);
            }

            if (!EMPTY.equals(right)) {
                int rightIndex = parentIndex * 2 + 1;
                tree[rightIndex] = right;
                indexes.put(right, rightIndex);
            }
        }
    }

    public String preOrder(int parentIndex) {
        StringBuilder sb = new StringBuilder();
        pre(parentIndex, sb);
        return sb.toString();
    }

    private void pre(int parentIndex, StringBuilder sb) {

        if (parentIndex >= tree.length || tree[parentIndex] == null) {
            return;
        }

        int leftIndex = parentIndex * 2;
        int rightIndex = parentIndex * 2 + 1;

        sb.append(tree[parentIndex]);
        pre(leftIndex, sb);
        pre(rightIndex, sb);
    }

    public String inOrder(int parentIndex) {
        StringBuilder sb = new StringBuilder();
        in(parentIndex, sb);
        return sb.toString();
    }

    private void in(int parentIndex, StringBuilder sb) {

        if (parentIndex >= tree.length || tree[parentIndex] == null) {
            return;
        }

        int leftIndex = parentIndex * 2;
        int rightIndex = parentIndex * 2 + 1;

        in(leftIndex, sb);
        sb.append(tree[parentIndex]);
        in(rightIndex, sb);
    }

    public String postOrder(int parentIndex) {
        StringBuilder sb = new StringBuilder();
        post(parentIndex, sb);
        return sb.toString();
    }

    public void post(int parentIndex, StringBuilder sb) {

        if (parentIndex >= tree.length || tree[parentIndex] == null) {
            return;
        }

        int leftIndex = parentIndex * 2;
        int rightIndex = parentIndex * 2 + 1;

        post(leftIndex, sb);
        post(rightIndex, sb);
        sb.append(tree[parentIndex]);
    }
}

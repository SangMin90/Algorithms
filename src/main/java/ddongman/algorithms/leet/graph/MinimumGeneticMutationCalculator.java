package ddongman.algorithms.leet.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumGeneticMutationCalculator {

    private boolean[] visited;

    public int minMutation(String startGene, String endGene, String[] bank) {

        visited = new boolean[bank.length];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startGene, 0));
        while (!queue.isEmpty()) {
            Node polled = queue.poll();

            for (int i = 0; i < bank.length; i++) {
                if (!visited[i] && isMutable(polled.getGene(), bank[i])) {
                    if (bank[i].equals(endGene)) {
                        return polled.getDepth() + 1;
                    }

                    queue.add(new Node(bank[i], polled.getDepth() + 1));
                    visited[i] = true;
                }
            }
        }

        return -1;
    }

    private boolean isMutable(String str, String validStr) {

        int count = 0;
        for (int i = 0; i < validStr.length(); i++) {
            if (validStr.charAt(i) != str.charAt(i)) {
                count++;
            }
        }

        return count == 1;
    }

    static class Node {
        private String gene;
        private int depth;

        public Node(String gene, int depth) {
            this.gene = gene;
            this.depth = depth;
        }

        public String getGene() {
            return gene;
        }

        public int getDepth() {
            return depth;
        }
    }
}

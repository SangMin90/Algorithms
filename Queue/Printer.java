import java.util.Comparator;
import java.util.LinkedList;

public class Printer {
    public static void main(String[] args) {
        Printer sample = new Printer();
        System.out.println(sample.solution(new int[]{2, 1, 3, 2}, 2));
    }
    public int solution(int[] priorities, int location) {

        LinkedList<Node> queue = new LinkedList<>();

        for (int i=0;i<priorities.length;i++) {
            queue.add(new Node(i, priorities[i]));
        }

        int order = 0;
        int max_idx = -1;

        while (max_idx != location) {
            Node max_node = queue.stream().max((Comparator.comparingInt(o -> o.value))).get();

            int idx = queue.indexOf(max_node);

            while (--idx >= 0) {
                queue.add(queue.poll());
            }

            queue.poll();

            max_idx = max_node.idx;
            order++;
        }

        return order;
    }

    class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}

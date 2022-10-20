import java.util.*;

public class AbsHeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] a = new int[N];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        AbsHeap sample = new AbsHeap();
        System.out.println(sample.solution(N, a));

    }

    public String solution(int N, int[] a) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (Math.abs(o1) != Math.abs(o2)) {
                return Integer.compare(Math.abs(o1), Math.abs(o2));
            } else {
                return o1.compareTo(o2);
            }
        });

        return getOutputString(a, sb, queue);
    }

    private String getOutputString(int[] a, StringBuilder sb, PriorityQueue<Integer> queue) {
        for (int i : a) {
            if (i == 0) {
                if (queue.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(queue.poll() + "\n");
                }
            } else {
                queue.add(i);
            }
        }

        return sb.toString();
    }

}

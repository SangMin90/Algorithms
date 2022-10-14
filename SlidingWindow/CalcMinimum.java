import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class CalcMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (canRemoveLast(deque.peekLast(), now)) {
                deque.pollLast();
            }

            deque.add(new Node(i, now));

            if (overWindow(L, deque.peekFirst(), i)) {
                deque.pollFirst();
            }

            bw.write(deque.peekFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }

    private static boolean overWindow(int L, Node first, int i) {
        return first.index < i - L + 1;
    }

    private static boolean canRemoveLast(Node last, int now) {
        return last != null && last.value > now;
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}

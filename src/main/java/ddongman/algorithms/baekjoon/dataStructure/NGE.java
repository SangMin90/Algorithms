package ddongman.algorithms.baekjoon.dataStructure;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class NGE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        NGE sample = new NGE();
        int[] solution = sample.solution(N, A);

        for (int i : solution) {
            bw.write(i + " ");
        }

        bw.flush();
        bw.close();
    }

    private int[] solution(int N, int[] A) {
        Deque<Node> stack = new ArrayDeque<>();
        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && stack.peek().value < A[i]) {
                answer[stack.peek().idx] = A[i];
                stack.pop();
            }

            if (stack.isEmpty() || stack.peek().value >= A[i]) {
                stack.push(new Node(i, A[i]));
            }
        }
        return answer;
    }

    public class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

}

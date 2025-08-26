package ddongman.algorithms.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        BubbleSort sample = new BubbleSort();
        System.out.println(sample.solution(N, A));
    }

    private int solution(int N, int[] A) {
        Node[] nodes = new Node[N];

        for (int i = 0; i < A.length; i++) {
            nodes[i] = new Node(i, A[i]);
        }

        Arrays.sort(nodes, Comparator.comparingInt(o -> o.value));

        int answer = 0;

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].idx - i > answer) {
                answer = nodes[i].idx - i;
            }
        }
        return answer + 1;
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
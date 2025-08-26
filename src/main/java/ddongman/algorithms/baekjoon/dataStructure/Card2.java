package ddongman.algorithms.baekjoon.dataStructure;

import java.util.LinkedList;
import java.util.Scanner;

public class Card2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        System.out.println(getLastCard(N));
    }

    private static int getLastCard(int N) {
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        return queue.poll();
    }
}

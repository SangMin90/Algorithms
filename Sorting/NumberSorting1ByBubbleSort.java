import java.util.Scanner;

public class NumberSorting1ByBubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        NumberSorting1ByBubbleSort sample = new NumberSorting1ByBubbleSort();

        int[] answer = sample.solution(N, A);

        for (int i : answer) {
            System.out.println(i);
        }

    }

    public int[] solution(int N, int[] A) {
        bubbleSort(N, A);
        return A;
    }

    public void bubbleSort(int N, int[] A) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
}

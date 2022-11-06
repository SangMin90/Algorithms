import java.io.IOException;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] a = new int[s.length()];

        for (int i = 0; i < a.length; i++) {
            a[i] = s.charAt(i) - '0';
        }

        SelectionSort sample = new SelectionSort();
        int[] number = sample.solution(a);
        for (int each : number) {
            System.out.print(each);
        }
    }

    private int[] solution(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int max = getMaxIdx(a, i);

            swap(a, i, max);
        }
        return a;
    }

    private void swap(int[] a, int i, int max) {
        int temp = a[i];
        a[i] = a[max];
        a[max] = temp;
    }

    private int getMaxIdx(int[] a, int i) {
        int max = i;
        for (int j = i; j < a.length; j++) {
            if (a[j] > a[max]) {
                max = j;
            }
        }
        return max;
    }
}
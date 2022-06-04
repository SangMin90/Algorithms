import java.util.Arrays;
import java.util.Scanner;
public class Lotto {
    static int k;
    static int[] a;
    static int[] c;
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length - 1;
        while (a[i-1] >= a[j]) {
            j -= 1;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length - 1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            k = sc.nextInt();
            if (k == 0) {
                sc.close();
                break;
            }
            a = new int[k];
            c = new int[k];
            for (int i=0;i<k;i++) {
                a[i] = sc.nextInt();
                if (i >= 6) {
                    c[i] = 1;
                }
            }
            Arrays.sort(a);
            do {
                for (int i=0;i<k;i++) {
                    if (c[i] == 0) {
                        System.out.print(a[i] + " ");
                    }
                }
                System.out.println();
            } while (nextPermutation(c));
            System.out.println();
        }
    }
}
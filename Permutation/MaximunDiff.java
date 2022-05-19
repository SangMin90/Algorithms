import java.util.Arrays;
import java.util.Scanner;

public class MaximunDiff {
    static int n;
    static int[] a;
    static int calculate(int[] a) {
        int sum = 0;
        for (int i=0;i<a.length-1;i++) {
            sum += Math.abs(a[i]-a[i+1]);
        }
        return sum;
    }
    static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while (i>0 && a[i-1]>=a[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = a.length-1;
        while (a[i-1]>=a[j]) {
            j -= 1;
        }
        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;
        j = a.length-1;
        while (i<j) {
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
        n = sc.nextInt();
        a = new int[n];
        for (int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int ans = 0;
        do {
            int temp = calculate(a);
            ans = Math.max(ans,temp);
        } while (nextPermutation(a));
        System.out.println(ans);
    }
}

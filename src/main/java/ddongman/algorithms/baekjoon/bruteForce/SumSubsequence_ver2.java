package ddongman.algorithms.baekjoon.bruteForce;

import java.util.Scanner;
public class SumSubsequence_ver2 {
    static boolean nextPermutation(int[] a) {
        int i = a.length - 1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }
        if (i<= 0) {
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
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++) {
            a[i] = sc.nextInt();
        }
        int[] c = new int[n];
        int ans = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (j >= (n-1)-i) {
                    c[j] = 1;
                } else {
                    c[j] = 0;
                }
            }
            do {
                int sum = 0;
                for (int k=0;k<n;k++) {
                    if (c[k] == 1) {
                        sum += a[k];
                    }
                }
                if (s == sum) {
                    ans += 1;
                }
            } while (nextPermutation(c));
        }
        System.out.println(ans);
    }
}
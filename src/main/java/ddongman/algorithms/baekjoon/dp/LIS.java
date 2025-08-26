package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;
public class LIS {
    static int[] d = new int[1001];
    static int[] a = new int[1001];
    static int go(int n) {
        if (n == 1) {
            return 1;
        }
        if (d[n] > 0) {
            return d[n];
        }
        d[n] = 1;
        for (int j=1;j<n;j++) {
            int temp = go(j) + 1;
            if (a[n] > a[j] && d[n] < temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1;i<=n;i++) {
            a[i] = sc.nextInt();
        }
        go(n);
        int ans = 1;
        for (int i=1;i<=n;i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}
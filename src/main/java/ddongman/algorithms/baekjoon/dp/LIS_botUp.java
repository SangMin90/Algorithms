package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;

public class LIS_botUp {
    static int[] d = new int[1001];
    static int[] a = new int[1001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=1;i<=n;i++) {
            a[i] = sc.nextInt();
        }
        for (int i=1;i<=n;i++) {
            d[i] = 1;
            for (int j=1;j<i;j++) {
                int temp = 0;
                if (a[i] > a[j]) {
                    temp = d[j] + 1;
                    if (d[i] < temp) {
                        d[i] = temp;
                    }
                }
            }
        }
        int ans = 0;
        for (int i=1;i<=n;i++) {
            if (ans < d[i]) {
                ans = d[i];
            }
        }
        System.out.println(ans);
    }
}

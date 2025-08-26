package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;
public class CardPurchase2 {
    static int[] d;
    static int[] p;
    static int go(int n) {
        if (n == 0) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        int temp = 0;
        for (int i=1;i<=n;i++) {
            temp = go(n-i) + p[i];
            if (d[n] == -1 || d[n] > temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        for (int i=1;i<=n;i++) {
            d[i] = -1;
        }
        p = new int[n+1];
        for (int i=1;i<=n;i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }
}
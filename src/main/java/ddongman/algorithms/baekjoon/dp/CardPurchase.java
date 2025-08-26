package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;
public class CardPurchase {
    static int[] p;
    static int[] d = new int[1001];
    static int go(int n) {
        if (n == 0) {
            return 0;
        }
        if (d[n] > 0) {
            return d[n];
        }
        for (int i=1;i<=n;i++) {
            int temp = go(n-i) + p[i];
            if (d[n] < temp) {
                d[n] = temp;
            }
        }
        return d[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        p = new int[n+1];
        for (int i=1;i<=n;i++) {
            p[i] = sc.nextInt();
        }
        System.out.println(go(n));
    }
}
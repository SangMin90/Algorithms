package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;
public class CardPurchaseBotUp {
    public static void main(String[] args) {
        int[] d;
        int[] p;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new int[n+1];
        p = new int[n+1];
        for (int i=1;i<=n;i++) {
            p[i] = sc.nextInt();
        }
        for (int i=1;i<=n;i++) {
            int temp = 0;
            for (int j=1;j<=i;j++) {
                temp = d[i-j]+p[j];
                if (d[i] < temp) {
                    d[i] = temp;
                }
            }
        }
        System.out.println(d[n]);
    }
}
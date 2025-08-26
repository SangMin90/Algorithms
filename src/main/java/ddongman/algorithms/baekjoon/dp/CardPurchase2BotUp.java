package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;

public class CardPurchase2BotUp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];
        int[] p = new int[n+1];
        for (int i=1;i<=n;i++) {
            p[i] = sc.nextInt();
            d[i] = -1;
        }
        for (int i=1;i<=n;i++) {
            int temp = 0;
            for (int j=1;j<=i;j++) {
                temp = d[i-j]+p[j];
                if (d[i] == -1 || d[i] > temp) {
                    d[i] = temp;
                }
            }
        }
        System.out.println(d[n]);
    }
}
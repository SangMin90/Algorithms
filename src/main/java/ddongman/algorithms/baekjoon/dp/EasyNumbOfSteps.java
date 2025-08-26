package ddongman.algorithms.baekjoon.dp;

import java.util.Scanner;

public class EasyNumbOfSteps {
    static long[][] d = new long[101][10];

    static long go(int n, int i) {
        if (n == 1) {
            if (i == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        if (d[n][i] > 0) {
            return d[n][i];
        }
        if (i == 0) {
            d[n][i] = go(n-1, i+1);
        } else if (i == 9) {
            d[n][i] = go(n-1, i-1);
        } else {
            d[n][i] = go(n-1, i-1) + go(n-1, i+1);
        }

        return d[n][i] % 1000000000;
    }

    static long bottomUp(int n) {
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    d[i][j] = d[i - 1][j + 1];
                } else if (j == 9) {
                    d[i][j] = d[i - 1][j - 1];
                } else {
                    d[i][j] = d[i - 1][j - 1] + d[i - 1][j + 1];
                }
                d[i][j] %= 1000000000;
            }
        }

        long ans = 0;
        for (int i=0;i<=9;i++) {
            ans += d[n][i];
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += go(n, i);
        }
        System.out.println(ans % 1000000000);
    }
}
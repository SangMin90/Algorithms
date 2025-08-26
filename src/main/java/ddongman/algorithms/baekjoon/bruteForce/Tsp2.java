package ddongman.algorithms.baekjoon.bruteForce;

import java.util.Scanner;

public class Tsp2 {
    static int n;
    static int[][] w;
    static int[] a;
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
        n = sc.nextInt();
        a = new int[n];
        for (int i=0;i<n;i++) {
            a[i] = i;
        }
        w = new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                w[i][j] = sc.nextInt();
            }
        }
        int ans = Integer.MAX_VALUE;
        do {
            if (a[0] != 0) {
                break;
            }
            boolean ok = true;
            int temp = 0;
            for (int i=0;i<n-1;i++) {
                if (w[a[i]][a[i+1]] == 0) {
                    ok = false;
                } else {
                    temp += w[a[i]][a[i+1]];
                }
            }
            if (ok && w[a[n-1]][a[0]] != 0) {
                temp += w[a[n-1]][a[0]];
                if (ans > temp) {
                    ans = temp;
                }
            }
        } while (nextPermutation(a));
        System.out.println(ans);
    }
}

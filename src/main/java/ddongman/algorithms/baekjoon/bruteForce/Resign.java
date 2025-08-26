package ddongman.algorithms.baekjoon.bruteForce;

import java.util.*;
public class Resign {
    static int n;
    static int ans = 0;
    static int[] t;
    static int[] p;
    static void go(int day, int sum) {
        if (day > n + 1) return;
        if (day == n + 1) {
            if (ans < sum) {
                ans = sum;
            }
            return;
        }
        go(day + t[day], sum+p[day]);
        go(day + 1, sum);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        for (int i=1; i<=n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        go(1,0);
        System.out.println(ans);
    }
}
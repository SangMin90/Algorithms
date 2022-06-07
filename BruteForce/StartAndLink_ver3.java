import java.util.ArrayList;
import java.util.Scanner;
public class StartAndLink_ver3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<(1<<n);i++) {
            int cnt = 0;
            for (int j=0;j<n;j++) {
                if ((i & (1 << j)) == 0) {
                    cnt += 1;
                }
            }
            if (cnt != n/2) {
                continue;
            }
            ArrayList<Integer> t1 = new ArrayList<>();
            ArrayList<Integer> t2 = new ArrayList<>();
            for (int j=0;j<n;j++) {
                if ((i & (1 << j)) == 0) {
                    t1.add(j);
                } else {
                    t2.add(j);
                }
            }
            int s1 = 0;
            int s2 = 0;
            for (int l1=0;l1<n/2;l1++) {
                for (int l2=0;l2<n/2;l2++) {
                    s1 += a[t1.get(l1)][t1.get(l2)];
                    s2 += a[t2.get(l1)][t2.get(l2)];
                }
            }
            int sum = Math.abs(s1-s2);
            if (ans > sum) {
                ans = sum;
            }
        }
        System.out.println(ans);
    }
}
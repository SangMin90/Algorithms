import java.util.Scanner;

public class StartAndLink_ver2 {
    static boolean nextPermutation(int[] c) {
        int i = c.length-1;
        while (i > 0 && c[i-1] >= c[i]) {
            i -= 1;
        }
        if (i <= 0) {
            return false;
        }
        int j = c.length - 1;
        while (c[i-1] >= c[j]) {
            j -= 1;
        }
        int temp = c[i-1];
        c[i-1] = c[j];
        c[j] = temp;
        j = c.length - 1;
        while (i < j) {
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        int[] c = new int[n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i=0;i<n;i++) {
            if (i >= (n/2)) {
                c[i] = 1;
            }
        }
        int ans = Integer.MAX_VALUE;
        do {
            int sum = 0;
            for (int i=0;i<n;i++) {
                for (int j=0;j<n;j++) {
                    if (c[i] == 0 && c[i] == c[j]) {
                        sum += a[i][j];
                    } else if (c[i] == 1 && c[i] == c[j]) {
                        sum -= a[i][j];
                    }
                }
            }
            if (ans > Math.abs(sum)) {
                ans = Math.abs(sum);
            }
        } while (nextPermutation(c));
        System.out.println(ans);
    }
}

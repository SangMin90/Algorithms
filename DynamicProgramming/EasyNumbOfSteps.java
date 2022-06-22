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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        for (int i=0;i<=9;i++) {
            ans += go(n, i);
        }
        System.out.println(ans % 1000000000);
    }
}
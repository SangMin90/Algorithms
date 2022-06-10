import java.util.Scanner;
public class TailingTwoByN2 {
    static int[] d = new int[1001];
    static int go(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 3;
        }
        if (d[n] > 0) {
            return d[n];
        }
        return d[n] = ((2*go(n-2))%10007 + go(n-1)%10007)%10007;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(go(n));
    }
}
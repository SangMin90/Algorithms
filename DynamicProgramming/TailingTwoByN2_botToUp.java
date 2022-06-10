import java.util.Scanner;
public class TailingTwoByN2_botToUp {
    public static void main(String[] args) {
        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 3;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=3;i<=n;i++) {
            d[i] = ((2*d[i-2])%10007 + d[i-1]%10007)%10007;
        }
        System.out.println(d[n]);
    }
}
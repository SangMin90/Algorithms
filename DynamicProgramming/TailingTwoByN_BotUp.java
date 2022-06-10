import java.util.Scanner;
public class TailingTwoByN_BotUp {
    public static void main(String[] args) {
        int[] d = new int[1001];
        d[1] = 1;
        d[2] = 2;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=3;i<=n;i++) {
            d[i] = (d[i-1]%10007 + d[i-2]%10007)%10007;
        }
        System.out.println(d[n]);
    }
}

import java.util.Scanner;
public class makeNumberToOne_botToUp {
    public static void main(String[] args) {
        int[] d = new int[1000001];
        d[1] = 0;
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=2;i<=n;i++) {
            d[i] = d[i-1] + 1;
            if (i%2 == 0) {
                int temp = d[i/2] + 1;
                if (d[i] > temp) {
                    d[i] = temp;
                }
            }
            if (i%3 == 0) {
                int temp = d[i/3] + 1;
                if (d[i] > temp) {
                    d[i] = temp;
                }
            }
        }
        System.out.println(d[n]);
    }
}
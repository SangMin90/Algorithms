import java.util.Scanner;

public class PieceOfPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[n][m];
        for (int i=0;i<n;i++) {
            String str = sc.nextLine();
            for (int j=0;j<m;j++) {
                a[i][j] = str.charAt(j)-'0';
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int h=0;h<(1<<(n*m));h++) {
            int sum = 0;
            for (int i=0;i<n;i++) {
                int cur = 0;
                for (int j=0;j<m;j++) {
                    int l = i*m+j;
                    if ((h&(1<<l)) == 0) {
                        cur = 10*cur+a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            for (int j=0;j<m;j++) {
                int cur = 0;
                for (int i=0;i<n;i++) {
                    int l = i*m+j;
                    if ((h&(1<<l)) != 0) {
                        cur = 10*cur+a[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            if (ans < sum) {
                ans = sum;
            }
        }
        System.out.println(ans);
    }
}

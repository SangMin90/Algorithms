import java.util.Scanner;
public class Guess {
    static int n;
    static int[][] sign;
    static int[] ans;
    static boolean check(int index) {
        int sum=0;
        for (int i=index;i>=0;i--) {
            sum+=ans[i];
            if (sign[i][index]==0) {
                if (sum!=0) return false;
            } else if (sign[i][index]>0) {
                if (sum<=0) return false;
            } else if (sign[i][index]<0) {
                if (sum>=0) return false;
            }
        }
        return true;
    }
    static boolean go(int index) {
        if (index == n) return true;
        if (sign[index][index] == 0) {
            ans[index]=0;
            return check(index) && go(index+1);
        } else {
            for (int i=1;i<=10;i++) {
                ans[index]=sign[index][index]*i;
                if (check(index) && go(index+1)) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sign = new int[n][n];
        ans = new int[n];
        String s = sc.next();
        int cnt = 0;
        for (int i=0;i<n;i++) {
            for (int j=i;j<n;j++) {
                char a = s.charAt(cnt);
                if (a == '+') sign[i][j] = 1;
                else if (a == '-') sign[i][j] = -1;
                else if (a == '0') sign[i][j] = 0;
                cnt++;
            }
        }
        go(0);
        for (int i=0;i<n;i++) System.out.println(ans[i]);
    }
}
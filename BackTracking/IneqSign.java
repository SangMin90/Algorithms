import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class IneqSign {
    static int k;
    static boolean[] check = new boolean[10];
    static char[] ineq;
    static ArrayList<String> ans = new ArrayList<>();
    static boolean keep(char a, char b, char op) {
        if (op == '<') if (a > b) return false;
        if (op == '>') if (a < b) return false;
        return true;
    }
    static void go(int index, String num) {
        if (index == k+1) {
            ans.add(num);
            return;
        }
        for (int i=0;i<10;i++) {
            if (check[i]) continue;
            if (index == 0 || keep(num.charAt(index-1),(char)(i+'0'),ineq[index-1])) {
                check[i] = true;
                go(index + 1, num + i);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        ineq = new char[k];
        for (int i=0;i<k;i++) ineq[i] = sc.next().charAt(0);
        go(0,"");
        Collections.sort(ans);
        System.out.println(ans.get(ans.size()-1));
        System.out.println(ans.get(0));
    }
}
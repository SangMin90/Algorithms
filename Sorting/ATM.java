import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < p.length; i++) {
            p[i] = sc.nextInt();
        }

        ATM sample = new ATM();

        System.out.println(sample.solution(p));
    }

    private int solution(int[] p) {
        for (int i = 1; i < p.length; i++) {
            int insertValue = p[i];
            int targetIdx = i - 1;
            while (targetIdx >= 0 && p[i] < p[targetIdx]) {
                targetIdx--;
            }
            targetIdx++;

            for (int j = i; j > targetIdx; j--) {
                p[j] = p[j - 1];
            }

            p[targetIdx] = insertValue;
        }
        return getSum(p);
    }

    private int getSum(int[] p) {
        int sum = 0;

        for (int i = 0; i < p.length; i++) {
            sum += (p.length - i) * p[i];
        }
        return sum;
    }
}
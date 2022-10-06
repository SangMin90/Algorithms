import java.util.Scanner;

public class SumOfNumbers5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start_index = 0;
        int end_index = 0;
        int cnt = 0;
        int sum = 0;
        while (end_index <= N) {
            if (end_index > N) {
                break;
            }
            if (sum == N) {
                cnt++;
            }
            if (sum <= N) {
                end_index++;
                sum += end_index;
            } else {
                start_index++;
                sum -= start_index;
            }
        }
        System.out.println(cnt);
    }
}
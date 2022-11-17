import java.util.Arrays;

public class TargetNumber {
    public static void main(String[] args) {
        TargetNumber sample = new TargetNumber();
        System.out.println(sample.solution(new int[]{4, 1, 2, 1}, 4));
    }

    public int solution(int[] numbers, int target) {
        int sum = Arrays.stream(numbers).sum();
        go(0, numbers, target, sum);
        return answer;
    }

    int answer = 0;

    void go(int idx, int[] numbers, int target, int sum) {
        if (idx == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        if (sum == target) {
            answer++;
            return;
        }

        go(idx + 1, numbers, target, sum);
        go(idx + 1, numbers, target, sum -= numbers[idx] * 2);
    }
}

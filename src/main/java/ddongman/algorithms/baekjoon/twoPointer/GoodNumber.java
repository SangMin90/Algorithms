package ddongman.algorithms.baekjoon.twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class GoodNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        GoodNumber sample = new GoodNumber();
        System.out.println(sample.solution(A));
    }

    public int solution(int[] numbers) {
        int iterCnt = numbers.length;
        int answer = 0;

        answer = getGoodNumberCnt(numbers);

        return answer;
    }

    private int getGoodNumberCnt(int[] numbers) {
        int iterCnt = numbers.length;
        int count = 0;

        for (int k = 0; k < iterCnt; k++) {
            int start_idx = 0;
            int end_idx = iterCnt - 1;

            while (start_idx < end_idx) {
                if (numbers[start_idx] + numbers[end_idx] == numbers[k]) {
                    if (start_idx != k && end_idx != k) {
                        count++;
                        break;
                    } else if (start_idx == k) {
                        start_idx++;
                    } else if (end_idx == k) {
                        end_idx--;
                    }
                } else if (numbers[start_idx] + numbers[end_idx] < numbers[k]) {
                    start_idx++;
                } else {
                    end_idx--;
                }
            }
        }

        return count;
    }
}
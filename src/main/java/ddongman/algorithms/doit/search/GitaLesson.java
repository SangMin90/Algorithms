package ddongman.algorithms.doit.search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GitaLesson {
    private int[] sum;
    private int[] bluray;

    public int solution(int n, int m, int[] len) {
        init(m, len);

        return binarySearch(m, 1, n);
    }

    private void init(int m, int[] len) {
        sum = new int[len.length + 1];
        bluray = new int[m];

        prefixSum(len);
    }

    private int binarySearch(int m, int start, int end) {
        while (--m > 0) {
            int mid = (start + end) / 2;
            bluray[m] = sum[mid] - sum[start - 1];

            start = mid + 1;
        }

        // 마지막 블루레이값
        bluray[m] = sum[end] - sum[start - 1];

        return Arrays.stream(bluray).max().getAsInt();
    }

    private void prefixSum(int[] len) {
        IntStream.range(0, len.length).forEach(i -> sum[i + 1] = sum[i] + len[i]);
    }
}

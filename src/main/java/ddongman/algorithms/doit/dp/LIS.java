package ddongman.algorithms.doit.dp;

public class LIS {

    private final int N;
    private final int[] b;
    private final int[] dp;

    public LIS(int N) {
        this.N = N;

        b = new int[N];
        dp = new int[N];
    }

    public int[] find(int[] sequence) {

        dp[0] = sequence[0];
        b[0] = sequence[0];
        int len = 1;

        for (int i = 0; i < N; i++) {

            int element = sequence[i];

            int index = len - 1;
            int insertIndex = findInsertIndex(index, element);
            len = b[index] < element ? len + 1 : len;

            b[insertIndex] = element;
            dp[i] = insertIndex;
        }

        return findLIS(len, sequence);
    }

    private int[] findLIS(int len, int[] sequence) {

        int[] lis = new int[len];
        for (int i = N - 1; i >= 0; i--) {

            if (len < 0) {
                break;
            }

            if (dp[i] == len - 1) {
                lis[--len] = sequence[i];
            }
        }

        return lis;
    }

    private int findInsertIndex(int index, int element) {
        return b[index] < element ? index + 1 : binarySearch(element, 0, index);
    }

    private int binarySearch(int element, int start, int end) {
        if (start >= end) {
            return end;
        }

        int mid = (start + end) / 2;

        if (element < b[mid]) {
            return binarySearch(element, start, mid);
        }

        if (element > b[mid]) {
            return binarySearch(element, mid + 1, end);
        }

        return mid;
    }
}

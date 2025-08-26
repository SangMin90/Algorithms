package ddongman.algorithms.doit.search;

public class FinderKthNumberInArray {
    public int solution(int n, int k) {
        return findKthNumber(n, k);
    }

    private int findKthNumber(int n, int k) {
        int start = 1;
        int end = k;

        while (start <= end) {
            int mid = (start + end) / 2;
            int i = 0;
            int count = 0;
            while (++i <= n) {
                count += Math.min(mid / i, n);
            }

            if (count < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}

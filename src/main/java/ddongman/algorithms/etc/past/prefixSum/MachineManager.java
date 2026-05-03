package ddongman.algorithms.etc.past.prefixSum;

import ddongman.algorithms.etc.past.domain.Machine;
import ddongman.algorithms.etc.past.domain.ProductLine;

import java.util.Objects;
import java.util.PriorityQueue;

public class MachineManager {

    private final int N;
    private final int[] diff;
    private final ProductLine[] lines;
    private final BinarySearch binarySearch;
    private final int[] machinery;

    public MachineManager(int N, ProductLine[] lines, int[] machinery) {

        this.N = N;
        this.diff = new int[N];
        this.lines = lines;
        binarySearch = new BinarySearch(machinery);
        this.machinery = machinery;
    }

    public int scrap(int K) {

        PriorityQueue<Machine> machines = new PriorityQueue<>();

        for (ProductLine line : lines) {
            int startIndex = binarySearch.lowerBound(0, N - 1, line.start());
            int endIndex = binarySearch.upperBound(0, N - 1, line.end());

            diff[startIndex]++;
            if (endIndex < N - 1) {
                diff[endIndex + 1]--;
            }
        }

        machines.add(new Machine(machinery[0], diff[0]));
        for (int i = 0; i < N - 1; i++) {
            diff[i + 1] += diff[i];
            machines.add(new Machine(machinery[i + 1], diff[i + 1]));
        }

        while (--K >= 0) {
            machines.poll();
        }

        return Objects.requireNonNull(machines.poll()).getNumber();
    }

    static class BinarySearch {

        private final int[] machinery;

        public BinarySearch(int[] machinery) {
            this.machinery = machinery;
        }

        public int lowerBound(int start, int end, int target) {

            while (start < end) {
                int mid = (start + end) / 2;

                if (machinery[mid] >= target) {
                    end = mid;
                } else if (machinery[mid] < target) {
                    start = mid + 1;
                }
            }

            return start;
        }

        public int upperBound(int start, int end, int target) {

            while (start < end) {
                int mid = (start + end + 1) / 2;
                if (machinery[mid] <= target) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }

            return start;
        }
    }
}

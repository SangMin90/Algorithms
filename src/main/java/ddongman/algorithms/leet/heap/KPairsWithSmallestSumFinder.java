package ddongman.algorithms.leet.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSumFinder {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Pair::compareTo);

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (pq.size() == k) {
                    Pair max = pq.peek();
                    if (max.num1 + max.num2 <= num1 + num2) {
                        break;
                    } else {
                        pq.poll();
                    }
                }
                pq.add(new Pair(num1, num2));
            }
        }

        return pq.stream().map(ele -> List.of(ele.num1, ele.num2)).toList();
    }

    record Pair(int num1, int num2) implements Comparable<Pair> {

        @Override
        public int compareTo(Pair o) {
            return Integer.compare((o.num1 + o.num2), (this.num1 + this.num2));
        }
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        PriorityQueue<Pair2> pq = new PriorityQueue<>(Pair2::compareTo);

        int num2 = nums2[0];

        for (int i = 0; i < nums1.length; i++) {
            if (pq.size() == k) {
                break;
            }
            pq.add(new Pair2(nums1[i], num2, i, 0));
        }

        List<List<Integer>> result = new ArrayList<>();
        while (result.size() < k && !pq.isEmpty()) {
            Pair2 min = pq.poll();

            result.add(List.of(min.num1, min.num2));
            if (min.idx2 + 1 < nums2.length) {
                pq.add(new Pair2(nums1[min.idx1], nums2[min.idx2 + 1], min.idx1, min.idx2 + 1));
            }
        }

        return result;
    }

    record Pair2(int num1, int num2, int idx1, int idx2) implements Comparable<Pair2> {

        @Override
        public int compareTo(Pair2 o) {
            return Integer.compare((this.num1 + this.num2), (o.num1 + o.num2));
        }
    }

    public List<List<Integer>> kSmallestPairs3(int[] nums1, int[] nums2, int k) {

        int left = nums1[0] + nums2[0];
        int right = nums1[nums1.length - 1] + nums2[nums2.length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (valid(mid, nums1, nums2, k)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] + nums2[0] >= left) {
                break;
            }
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] + nums2[j] < left) {
                    result.add(Arrays.asList(nums1[i], nums2[j]));
                } else {
                    break;
                }
            }
        }

        int need = k - result.size();
        for (int i = 0; i < nums1.length && need > 0; i++) {
            if (nums1[i] + nums2[0] > left) {
                break;
            }
            for (int j = 0; j < nums2.length && need > 0; j++) {
                if (nums1[i] + nums2[j] == left) {
                    result.add(List.of(nums1[i], nums2[j]));
                    need--;
                }
            }
        }

        return result;
    }

    private boolean valid(int mid, int[] nums1, int[] nums2, int k) {

        int count = 0;
        int j = nums2.length - 1;
        for (int i = 0; i < nums1.length; i++) {
            while (j >= 0 && nums1[i] + nums2[j] > mid) {
                j--;
            }
            count += j + 1;
            if (count >= k) {
                return true;
            }
        }

        return false;
    }
}

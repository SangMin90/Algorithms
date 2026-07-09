package ddongman.algorithms.leet.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceChecker {

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {

            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        List<Integer>[] dp = new ArrayList[26];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }

        for (int i = 0; i < t.length(); i++) {
            dp[t.charAt(i) - 'a'].add(i);
        }

        int currIdx = -1;
        for (char c : s.toCharArray()) {

            int idx = c - 'a';
            if (dp[idx].isEmpty()) {
                return false;
            }

            currIdx = binarySearch(dp[idx], currIdx);

            if (currIdx == -1) {
                return false;
            }
        }

        return true;
    }

    private int binarySearch(List<Integer> arr, int idx) {

        int start = 0;
        int end = arr.size() - 1;

        while (start <= end) {
            int mid = (start + end) >>> 1;
            int midVal = arr.get(mid);

            if (midVal > idx) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start >= arr.size() ? -1 : arr.get(start);
    }
}

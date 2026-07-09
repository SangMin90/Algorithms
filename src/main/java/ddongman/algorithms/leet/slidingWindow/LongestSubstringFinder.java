package ddongman.algorithms.leet.slidingWindow;

import java.util.Arrays;

public class LongestSubstringFinder {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        boolean[] visited = new boolean[128];

        int start = 0;
        int end = 1;

        int maxLen = 1;

        visited[s.charAt(start)] = true;

        while (end < s.length()) {

            if (visited[s.charAt(end)]) {
                maxLen = Math.max(maxLen, end - start);

                visited[s.charAt(start++)] = false;
            } else  {
                visited[s.charAt(end++)] = true;
            }
        }

        return Math.max(maxLen, end - start);
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] visited = new int[128];
        Arrays.fill(visited, -1);

        int start = 0;
        int end = 0;

        int maxLen = 1;

        while (end < s.length()) {
            if (visited[s.charAt(end)] == -1 || start > visited[s.charAt(end)]) {
                visited[s.charAt(end)] = end++;
            } else {
                maxLen = Math.max(maxLen, end - start);

                start = visited[s.charAt(end)] + 1;
            }
        }

        return Math.max(maxLen, end - start);
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int[] visited = new int[128];
        Arrays.fill(visited, -1);

        int start = 0;
        int end = 0;

        int maxLen = 0;

        while (end < s.length()) {

            char endIndex = s.charAt(end);
            if (visited[endIndex] >= start) {
                maxLen = Math.max(maxLen, end - start);
                start = visited[endIndex] + 1;
            }
            visited[endIndex] = end++;
        }

        return Math.max(maxLen, end - start);
    }
}

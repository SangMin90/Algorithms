package ddongman.algorithms.leet.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreaker {

    Node root = new Node();
    Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {

        memo = new Boolean[s.length()];

        for (String word : wordDict) {
            addWord(word);
        }

        return searchWord(s, 0);
    }

    void addWord(String word) {
        root.addWord(word);
    }

    boolean searchWord(String s, int index) {

        if (index == s.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        Node curr = root;
        for (int i = index; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                break;
            }

            curr = curr.children[idx];

            if (curr.isEnd) {
                if (searchWord(s, i + 1)) {
                    return memo[index] = true;
                }
            }
        }

        return memo[index] = false;
    }


    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;

        void addWord(String word) {

            Node curr = this;

            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }

                curr = curr.children[c - 'a'];
            }

            curr.isEnd = true;
        }
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}

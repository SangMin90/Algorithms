package ddongman.algorithms.leet.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    private Map<String, List<String>> adj = new HashMap<>();
    private Map<String, Boolean> visited = new HashMap<>();

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        for (int i = 0; i < wordList.size(); i++) {
            String s1 = wordList.get(i);
            if (!adj.containsKey(s1)) {
                adj.put(s1, new ArrayList<>());
            }

            for (int j = i; j < wordList.size(); j++) {
                String s2 = wordList.get(j);
                if (isTransform(s1, s2)) {
                    adj.get(s1).add(s2);

                    if (!adj.containsKey(s2)) {
                        adj.put(s2, new ArrayList<>());
                    }

                    adj.get(s2).add(s1);
                }
            }
        }

        if (!adj.containsKey(beginWord)) {
            adj.put(beginWord, new ArrayList<>());
            for (String s : wordList) {
                if (isTransform(beginWord, s)) {
                    adj.get(beginWord).add(s);
                    adj.get(s).add(beginWord);
                }
            }
        }

        Queue<String> queue = new ArrayDeque<>();

        int level = 1;
        queue.add(beginWord);
        visited.put(beginWord, true);
        while (!queue.isEmpty()) {

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String polled = queue.poll();

                if (polled.equals(endWord)) {
                    return level;
                }

                List<String> linked = adj.get(polled);
                for (String s : linked) {
                    if (!visited.containsKey(s)) {
                        queue.add(s);
                        visited.put(s, true);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    private boolean isTransform(String s1, String s2) {

        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        wordSet.remove(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String polled = queue.poll();

                if (endWord.equals(polled)) {
                    return level;
                }

                List<String> possibleWords = findPossibleTransformedWord(polled);
                for (String s : possibleWords) {
                    if (wordSet.contains(s)) {
                        queue.add(s);
                        wordSet.remove(s);
                    }
                }
            }

            level++;
        }

        return 0;
    }

    private List<String> findPossibleTransformedWord(String s) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            String before = s.substring(0, i);
            String after = s.substring(i + 1);

            for (int j = 0; j < 26; j++) {
                result.add(before + (char) ('a' + j) + after);
            }
        }

        return result;
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        wordSet.remove(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String polled = queue.poll();

                if (endWord.equals(polled)) {
                    return level;
                }

                char[] chars = polled.toCharArray();
                for (int j = 0; j < chars.length; j++) {

                    char org = chars[j];

                    for (int k = 0; k < 26; k++) {
                        chars[j] = (char) ('a' + k);
                        if (org == chars[j]) {
                            continue;
                        }

                        String str = String.valueOf(chars);
                        if (wordSet.contains(str)) {
                            queue.add(str);
                            wordSet.remove(str);
                        }
                    }

                    chars[j] = org;
                }
            }

            level++;
        }

        return 0;
    }

    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        int level = 1;
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevelSet = new HashSet<>();
            for (String word : beginSet) {

                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char org = chars[i];
                    for (int k = 0; k < 26; k++) {
                        chars[i] = (char) ('a' + k);

                        if (org == chars[i]) {
                            continue;
                        }

                        String nextWord = String.valueOf(chars);
                        if (endSet.contains(nextWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(nextWord)) {
                            nextLevelSet.add(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                    chars[i] = org;
                }
            }

            beginSet = nextLevelSet;
            level++;
        }

        return 0;
    }
}

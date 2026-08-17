package ddongman.algorithms.leet.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenatedWordsFinder {

    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        if (s.length() < totalLen) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int start = 0;
        int end = totalLen;

        int sbIndex = 0;
        StringBuilder[] sb = new StringBuilder[words.length];
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < totalLen; i++) {
            word.append(s.charAt(i));
            if (word.length() == wordLen) {
                sb[sbIndex++] = word;
                word = new StringBuilder();
            }
        }

        while (start <= end && end <= s.length()) {
            Map<String, Integer> windowCount = new HashMap<>(wordCount);

            for (int i = 0; i < sb.length; i++) {
                String wordStr = sb[i].toString();
                if (windowCount.getOrDefault(wordStr, 0) > 0) {
                    windowCount.put(wordStr, windowCount.get(wordStr) - 1);
                } else {
                    break;
                }
            }

            if (windowCount.values().stream().allMatch(val -> val == 0)) {
                result.add(start);
            }

            if (s.length() - start <= totalLen) {
                break;
            }

            for (int i = 0; i < sb.length; i++) {
                sb[i].deleteCharAt(0);

                if (i == sb.length - 1) {
                    sb[i].append(s.charAt(end));
                } else {
                    sb[i].append(sb[i + 1].charAt(0));
                }
            }

            start++;
            end++;
        }

        return result;
    }

    public List<Integer> findSubstring2(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        for (int offset = 0; offset < wordLen; offset++) {

            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            String[] substring = new String[(s.length() - offset) / wordLen];
            int substringIdx = 0;
            StringBuilder word = new StringBuilder();
            for (int j = offset; j < offset + substring.length * wordLen; j++) {
                word.append(s.charAt(j));

                if (word.length() == wordLen) {
                    substring[substringIdx++] = word.toString();
                    word.setLength(0);
                }
            }

            int start = 0;
            int end = 0;
            while (substring.length - start >= words.length) {
                if (wordCount.containsKey(substring[end])) {
                    wordCount.put(substring[end], wordCount.get(substring[end]) - 1);
                }

                if (end - start + 1 == words.length) {
                    if (isMatch(wordCount)) {
                        result.add(offset + start * wordLen);
                    }

                    if (wordCount.containsKey(substring[start])) {
                        wordCount.put(substring[start], wordCount.get(substring[start]) + 1);
                    }

                    start++;
                }

                end++;
            }
        }

        return result;
    }

    private boolean isMatch(Map<String, Integer> wordCount) {
        for (String word : wordCount.keySet()) {
            if (wordCount.get(word) != 0) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> findSubstring3(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        for (int offset = 0; offset < wordLen; offset++) {

            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            String[] substring = new String[(s.length() - offset) / wordLen];
            int substringIdx = 0;
            StringBuilder word = new StringBuilder();
            for (int j = offset; j < offset + substring.length * wordLen; j++) {
                word.append(s.charAt(j));

                if (word.length() == wordLen) {
                    substring[substringIdx++] = word.toString();
                    word.setLength(0);
                }
            }

            int count = 0;
            int start = 0;
            int end = 0;
            while (substring.length - start >= words.length) {
                if (wordCount.containsKey(substring[end])) {
                    if (wordCount.get(substring[end]) > 0) {
                        wordCount.put(substring[end], wordCount.get(substring[end]) - 1);
                        count++;
                    } else {
                        while (!substring[start].equals(substring[end]) ) {
                            if (wordCount.containsKey(substring[start])) {
                                wordCount.put(substring[start], wordCount.get(substring[start]) + 1);
                                count--;
                            }
                            start++;
                        }
                        start++;
                    }
                } else {
                    while (start < substring.length && start < end) {
                        if (wordCount.containsKey(substring[start])) {
                            wordCount.put(substring[start], wordCount.get(substring[start]) + 1);
                        }
                        start++;
                    }
                    end = start;
                    count = 0;
                }

                if (end - start + 1 == words.length) {
                    if (count == words.length) {
                        result.add(offset + start * wordLen);
                    }

                    if (wordCount.containsKey(substring[start])) {
                        wordCount.put(substring[start], wordCount.get(substring[start]) + 1);
                        count--;
                    }

                    start++;
                }

                end++;
            }
        }

        return result;
    }

    public List<Integer> findSubstring4(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        int wordLen = words[0].length();
        for (int offset = 0; offset < wordLen; offset++) {

            Map<String, Integer> wordCount = new HashMap<>();
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }

            int count = 0;
            int start = offset;
            int end = start;

            while (end + wordLen <= s.length()) {

                String word = s.substring(end, end + wordLen);
                end += wordLen;

                if (wordCount.containsKey(word) && wordCount.get(word) == 0) {

                    String suspect = s.substring(start, start + wordLen);
                    while (!word.equals(suspect)) {

                        if (wordCount.containsKey(suspect)) {
                            wordCount.put(suspect, wordCount.get(suspect) + 1);
                            count--;
                        }

                        start += wordLen;
                        suspect = s.substring(start, start + wordLen);
                    }

                    start += wordLen;

                    continue;
                }

                if (!wordCount.containsKey(word)) {

                    while (start < end) {
                        String suspect = s.substring(start, start + wordLen);
                        if (wordCount.containsKey(suspect)) {
                            wordCount.put(suspect, wordCount.get(suspect) + 1);
                            count--;
                        }

                        start += wordLen;
                    }

                    continue;
                }

                wordCount.put(word, wordCount.get(word) - 1);
                count++;

                if (count == words.length) {
                    result.add(start);

                    String startWord = s.substring(start, start + wordLen);
                    wordCount.put(startWord, wordCount.get(startWord) + 1);
                    start += wordLen;
                    count--;
                }
            }
        }

        return result;
    }

    public List<Integer> findSubstring5(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int count = 0;
        for (int offset = 0; offset < wordLen; offset++) {
            Map<String, Integer> windowCount = new HashMap<>();

            int start = offset;
            int end = start;
            while (end + wordLen <= s.length()) {
                String word = s.substring(end, end + wordLen);
                windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                end += wordLen;
                count++;

                Integer targetCount = wordCount.getOrDefault(word, 0);
                while (windowCount.get(word) > targetCount) {

                    String suspect = s.substring(start, start + wordLen);
                    windowCount.put(suspect, windowCount.get(suspect) - 1);
                    start += wordLen;
                    count--;
                }

                if (count == words.length) {
                    result.add(start);
                }
            }

            count = 0;
        }

        return result;
    }
}

package ddongman.algorithms.programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class WordChain {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        answer = getDropout(n, words);

        return answer;
    }

    Set<String> word_set = new HashSet<>();

    private int[] getDropout(int n, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (isDropout(n, words, i)) {
                return new int[]{i % n + 1, i / n + 1};
            }
        }
        return new int[]{0, 0};
    }

    private boolean isDropout(int n, String[] words, int i) {
        return (i != 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))
                || (!word_set.add(words[i]));
    }
}
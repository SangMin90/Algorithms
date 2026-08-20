package ddongman.algorithms.leet.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordMatcher {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> inversePatternMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {

            if (patternMap.containsKey(pattern.charAt(i))) {
                if (!patternMap.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (!inversePatternMap.containsKey(words[i])) {
                    patternMap.put(pattern.charAt(i), words[i]);
                    inversePatternMap.put(words[i], pattern.charAt(i));
                } else {
                    return inversePatternMap.get(words[i]).equals(pattern.charAt(i));
                }
            }
        }

        return true;
    }
}

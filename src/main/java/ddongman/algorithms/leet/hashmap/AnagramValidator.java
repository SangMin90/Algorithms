package ddongman.algorithms.leet.hashmap;

public class AnagramValidator {

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] cnt = new int[1 << 21];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.codePointAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (cnt[t.codePointAt(i)] == 0) {
                return false;
            } else {
                cnt[t.codePointAt(i)]--;
            }
        }

        return true;
    }
}

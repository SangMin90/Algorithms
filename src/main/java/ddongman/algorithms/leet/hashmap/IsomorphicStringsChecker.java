package ddongman.algorithms.leet.hashmap;

import java.util.Arrays;

public class IsomorphicStringsChecker {

    public boolean isIsomorphic(String s, String t) {

        int[] matched =  new int[128];
        int[] charToChar = new int[128];

        Arrays.fill(charToChar, -1);
        Arrays.fill(matched, -1);

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (charToChar[c1] == -1) {
                if (matched[c2] == -1) {
                    charToChar[c1] = c2;
                    matched[c2] = c1;
                } else {
                    return false;
                }
            } else {
                if (charToChar[c1] != c2) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isIsomorphic2(String s, String t) {

        int[] sMap = new int[128];
        int[] tMap = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (sMap[c1] != tMap[c2]) {
                return false;
            }
            sMap[c1] = i + 1;
            tMap[c2] = i + 1;
        }

        return true;
    }
}

package ddongman.algorithms.leet.hashmap;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] countMap = new int[26];
        for (char c : magazine.toCharArray()) {
            countMap[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            int idx = c - 'a';
            if (countMap[idx] == 0) {
                return false;
            }

            countMap[idx]--;
        }

        return true;
    }

    public boolean canConstructMoreFast(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] countMap = new int[26];
        for (char c : ransomNote.toCharArray()) {

            int i = magazine.indexOf(c, countMap[c - 'a']);
            if (i == -1) {
                return false;
            }

            countMap[c - 'a'] = i + 1;
        }

        return true;
    }
}

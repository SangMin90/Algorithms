package ddongman.algorithms.leet.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfPhoneNumberFinder {

    String[][] map;
    List<String> combinations = new ArrayList<>();

    public CombinationOfPhoneNumberFinder() {
        map = new String[][]{
            null,
            null,
            new String[]{"a", "b", "c"},
            new String[]{"d", "e", "f"},
            new String[]{"g", "h", "i"},
            new String[]{"j", "k", "l"},
            new String[]{"m", "n", "o"},
            new String[]{"p", "q", "r", "s"},
            new String[]{"t", "u", "v"},
            new String[]{"w", "x", "y", "z"},
        };
    }

    public List<String> letterCombinations(String digits) {

        backtrack(digits, 0, "");
        return combinations;
    }

    private void backtrack(String digits, int index, String combination) {

        if (index == digits.length()) {
            combinations.add(combination);
            return;
        }

        for (String s : map[digits.charAt(index) - '0']) {
            backtrack(digits, index + 1, combination + s);
        }
    }
}

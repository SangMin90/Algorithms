package ddongman.algorithms.programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class NewsClustering {
    public int solution(String str1, String str2) {

        int answer = 65536;

        List<String> set1 = createSet(str1);
        List<String> set2 = createSet(str2);

        int sizeA = set1.size();
        int sizeB = set2.size();

        if (sizeA == 0 && sizeB == 0) {
            return answer;
        }

        int count = (int)set1.stream().filter(set2::remove).count();
        return (count * answer) / (sizeA + sizeB - count);
    }

    private List<String> createSet(String s) {
        List<String> set = new ArrayList<>();

        for (int i = 0; i < s.length() - 1; i++) {
            String element = createElement(s, i);

            if (isLowerCase(element)) {
                set.add(element);
            }
        }

        return set;
    }

    private boolean isLowerCase(String element) {
        return element.matches("^[a-z]+$");
    }

    private String createElement(String s, int idx) {
        String sb = String.valueOf(s.charAt(idx)) +
                s.charAt(idx + 1);

        return sb.toLowerCase();
    }
}

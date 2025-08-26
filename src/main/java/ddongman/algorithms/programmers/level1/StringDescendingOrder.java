package ddongman.algorithms.programmers.level1;

import java.util.Arrays;

public class StringDescendingOrder {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        StringBuilder answer = new StringBuilder();
        for (int i= charArray.length-1;i>=0;i--) {
            answer.append(charArray[i]);
        }
        return answer.toString();
    }
}

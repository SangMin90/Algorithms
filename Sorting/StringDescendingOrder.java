import java.util.Arrays;

public class StringDescendingOrder {
    public String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String answer = "";
        for (int i= charArray.length-1;i>=0;i--) {
            answer += String.valueOf(charArray[i]);
        }
        return answer;
    }
}

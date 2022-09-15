import java.util.Arrays;

public class StringCustomizedOrder {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            if (s1.charAt(n) < s2.charAt(n)) {
                return -1;
            } else if (s1.charAt(n) > s2.charAt(n)) {
                return 1;
            } else {
                return s1.compareTo(s2);
            }
        });
        String[] answer = strings;
        return answer;
    }
}

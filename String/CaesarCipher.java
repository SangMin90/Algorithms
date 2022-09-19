import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CaesarCipher {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i])) {
                chars[i] = (char) ((chars[i] + n - 'a') % 26 + 'a');
            }
            if (Character.isUpperCase(chars[i])) {
                chars[i] = (char) ((chars[i] + n - 'A') % 26 + 'A');
            }
        }

        String answer = new String(chars);
        return answer;
    }
}

import java.util.StringTokenizer;

public class JadenCaseString {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s," ",true);

        String answer = getJadenString(st);

        return answer;
    }

    private String getJadenString(StringTokenizer st) {
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreTokens()) {
            char[] word = st.nextToken().toCharArray();
            for (int j = 0; j < word.length; j++) {
                if (j == 0) {
                    word[j] = Character.toUpperCase(word[j]);
                } else {
                    word[j] = Character.toLowerCase(word[j]);
                }
            }
            sb.append(word);
        }
        return sb.toString();
    }
}
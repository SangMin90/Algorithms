public class MiddleLetterGetting {
    public String solution(String s) {
        String answer = null;
        if (s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            answer = String.valueOf(s.charAt(s.length()/2));
        }
        return answer;
    }
}
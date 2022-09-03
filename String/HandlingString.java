public class HandlingString {
    public boolean solution(String s) {
        boolean answer = (s.length() == 4 || s.length() == 6) && s.matches("^[0-9]+$");
        return answer;
    }
}
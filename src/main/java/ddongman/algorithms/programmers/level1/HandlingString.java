package ddongman.algorithms.programmers.level1;

public class HandlingString {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.matches("^[0-9]+$");
    }
}
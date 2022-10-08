import java.util.ArrayDeque;
import java.util.Deque;

public class CorrectParenthesis {
    Deque<Character> deque = new ArrayDeque<>();
    boolean solution(String s) {
        for (Character c : s.toCharArray()) {
            if (isParenthesis(c)) {
                deque.pollLast();
            } else {
                deque.add(c);
            }

        }

        return deque.isEmpty();
    }

    boolean isParenthesis(Character c) {
        if (c.compareTo(')') == 0 &&
                deque.peekLast() != null &&
                deque.peekLast().compareTo('(') == 0) return true;
        else return false;
    }
}

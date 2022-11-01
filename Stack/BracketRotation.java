import java.util.ArrayDeque;
import java.util.Deque;

public class BracketRotation {

    Deque<Character> stack;
    char[] brackets;
    int len;

    public int solution(String s) {
        int idx = 0;
        int answer = 0;

        len = s.length();
        brackets = s.toCharArray();
        stack = new ArrayDeque<>();

        while (idx < len) {
            if (isCorrectBrackets(idx)) {
                answer++;
            }

            idx++;
            stack.clear();
        }

        return answer;
    }

    private boolean isCorrectBrackets(int startIdx) {
        for (int i = startIdx; i < startIdx + len; i++) {
            if (isPair(i)) {
                stack.pollLast();
            } else {
                stack.addLast(brackets[i % len]);
            }
        }

        return stack.isEmpty();
    }

    private boolean isPair(int idx) {
        return (!stack.isEmpty() && brackets[idx % len] == ']' && stack.peekLast() == '[') ||
                (!stack.isEmpty() && brackets[idx % len] == '}' && stack.peekLast() == '{') ||
                (!stack.isEmpty() && brackets[idx % len] == ')' && stack.peekLast() == '(');
    }
}

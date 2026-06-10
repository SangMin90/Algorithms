package ddongman.algorithms.leet.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesValidator {

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char top = stack.peek();
                if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.peek();
            if (c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{') {
                stack.pop();
            } else  {
                return false;
            }

        }

        return stack.isEmpty();
    }

    public boolean isValid3(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();
            if (!(c == ')' && top == '(' || c == ']' && top == '[' || c == '}' && top == '{')) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid4(String s) {

        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid5(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        char[] stack = new char[s.length()];
        int index = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack[index++] = ')';
            } else if (c == '{') {
                stack[index++] = '}';
            } else if (c == '[') {
                stack[index++] = ']';
            } else {
                if (index == 0 || stack[--index] != c) {
                    return false;
                }
            }
        }

        return index == 0;
    }
}

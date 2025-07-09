package ddongman.doit.greedy;

import java.util.*;

import static ddongman.doit.greedy.LostParenthesis.Sign.MINUS;
import static ddongman.doit.greedy.LostParenthesis.Sign.PLUS;

public class LostParenthesis {
    private Deque<Sign> signs;
    private List<Long> nums;
    public long solution(String expression) {
        init(expression);

        reassignSigns();

        return calculate();
    }

    private long calculate() {
        return nums.stream()
                .mapToLong(num -> {
                    Sign sign = signs.pop();
                    if (MINUS.equals(sign)) {
                        num *= -1;
                    }

                    return num;
                })
                .sum();
    }

    private void init(String expression) {
        signs = new LinkedList<>();
        nums = new ArrayList<>();

        int i = 0;
        if (!isNum(expression.charAt(i))) {
            signs.add(Sign.fromValue(expression.charAt(i) + ""));
            i++;
        } else {
            signs.add(PLUS);
        }

        while(i < expression.length()) {
            if (!isNum(expression.charAt(i))) {
                signs.add(Sign.fromValue(expression.charAt(i) + ""));
                i++;
                continue;
            }

            StringBuffer sb = new StringBuffer();
            while (i < expression.length() && isNum(expression.charAt(i))) {
                sb.append(expression.charAt(i));
                i++;
            }
            nums.add(Long.parseLong(sb.toString()));
        }
    }

    private void reassignSigns() {
        int i = 0;
        while (i < nums.size()) {
            Sign sign = signs.peek();
            if (PLUS.equals(sign)) {
                signs.add(signs.pop());
                i++;
                continue;
            }

            signs.add(signs.pop());
            i++;
            Sign targetSign = signs.peek();
            while (i < nums.size() && PLUS.equals(targetSign)) {
                signs.pop();
                signs.add(MINUS);
                i++;
            }
        }
    }

    private boolean isNum(char c) {
        return c - '0' >= 0 && c - '0' <= 9;
    }

    enum Sign {
        MINUS("-"), PLUS("+");

        private final String value;

        Sign(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Sign fromValue(String value) {
            return Arrays.stream(values())
                    .filter(code -> code.getValue().equals(value))
                    .findAny()
                    .orElse(null);
        }
    }
}

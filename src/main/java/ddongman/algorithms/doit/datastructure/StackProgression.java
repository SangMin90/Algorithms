package ddongman.algorithms.doit.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static ddongman.algorithms.doit.datastructure.StackProgression.StackOperator.POP;
import static ddongman.algorithms.doit.datastructure.StackProgression.StackOperator.PUSH;

public class StackProgression {

    public String solution(int n, int[] numbers) {
        return getPushPop(n, numbers);
    }

    private String getPushPop(int n, int[] numbers) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<StackOperator> operators = new ArrayList<>();

        int initIndex = 0;
        int i = 0;
        while (i < n) {
            int num = i + 1;
            stack.push(num);
            operators.add(PUSH);

            while (!stack.isEmpty() && stack.peek() == numbers[initIndex]) {
                stack.pop();
                operators.add(POP);
                initIndex++;
            }

            i++;
        }

        return stack.isEmpty() ? String.join(""
                , operators.stream()
                        .map(StackOperator::getOperator)
                        .toList()) : "NO";
    }

    enum StackOperator {
        PUSH("+"),
        POP("-");

        private final String operator;

        StackOperator(String operator) {
            this.operator = operator;
        }

        public String getOperator() {
            return operator;
        }
    }
}

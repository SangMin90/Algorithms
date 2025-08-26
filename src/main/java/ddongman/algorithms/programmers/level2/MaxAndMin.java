package ddongman.algorithms.programmers.level2;

import java.util.Arrays;

public class MaxAndMin {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(numbers);
        int min = numbers[0];
        int max = numbers[numbers.length - 1];
        return min + " " + max;
    }
}

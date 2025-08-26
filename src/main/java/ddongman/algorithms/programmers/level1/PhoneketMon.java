package ddongman.algorithms.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class PhoneketMon {
    public int solution(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return Math.min(numbers.size(), nums.length / 2);
    }
}
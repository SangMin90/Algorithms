import java.util.*;
import java.util.stream.Collectors;

public class PhoneketMon {
    public int solution(int[] nums) {
        Set<Integer> numbers = new HashSet(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int answer = 0;
        if (numbers.size() < nums.length / 2) {
            answer = numbers.size();
        } else {
            answer = nums.length / 2;
        }
        return answer;
    }
}
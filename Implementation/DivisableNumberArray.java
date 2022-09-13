import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisableNumberArray {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> temp = new ArrayList<>();
        for (int each:arr) {
            if (each % divisor == 0) {
                temp.add(each);
            }
        }
        Collections.sort(temp);
        if (temp.isEmpty()) {
            temp.add(-1);
        }
        int[] answer = temp.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

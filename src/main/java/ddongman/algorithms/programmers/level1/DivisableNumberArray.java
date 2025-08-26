package ddongman.algorithms.programmers.level1;

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
        return temp.stream().mapToInt(i -> i).toArray();
    }
}

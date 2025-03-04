package ddongman.doit.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class BubbleSortProgram {
    public int solution(int n, int[] numbers) {
        Map<Integer, Integer> indexMap = IntStream.range(0, n)
                .boxed()
                .collect(toMap(i -> numbers[i], Function.identity()));

        Collections.sort(new ArrayList<>(indexMap.keySet()));

        int result = numbers[0];
        Integer beforeIndex = 0;
        for (Integer key : indexMap.keySet()) {
            Integer currIndex = indexMap.get(key);

            if (currIndex.compareTo(beforeIndex) < 0) {
                result = numbers[beforeIndex];
                break;
            }

            beforeIndex = currIndex;
        }

        return result;
    }
}

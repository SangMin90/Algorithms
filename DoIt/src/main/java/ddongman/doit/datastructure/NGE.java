package ddongman.doit.datastructure;

import java.util.stream.IntStream;

public class NGE {
    public int[] solution(int n, int[] numbers) {
        return IntStream.range(0, n)
                .map(i -> {
                    int j = i;
                    while (j < n && numbers[i] >= numbers[j]) {
                        j++;
                    }

                    if (j == n) {
                        return -1;
                    } else {
                        return numbers[j];
                    }
                }).toArray();
    }
}

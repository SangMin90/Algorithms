package ddongman.doit.sort;

import java.util.stream.IntStream;

public class Sorter {
    public int[] bubbleSort(int[] numbers) {
        IntStream.range(0, numbers.length)
                .forEach(i ->
                    IntStream.range(0, numbers.length - i - 1)
                            .forEach(j -> {
                                if (numbers[j] > numbers[j + 1]) {
                                    int temp = numbers[j];
                                    numbers[j] = numbers[j + 1];
                                    numbers[j + 1] = temp;
                                }
                            })
                );

        return numbers;
    }
}

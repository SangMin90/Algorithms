package ddongman.doit.sort;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SelectionSort {
    public String solution(char[] numbers) {
        return IntStream.range(0, numbers.length)
                .map(currIndex -> {
                    int minIndex = findIndexOfMaxNum(currIndex, numbers);
                    int result = numbers[minIndex] - '0';
                    swap(currIndex, minIndex, numbers);

                    return result;
                }).mapToObj(String::valueOf).collect(Collectors.joining());
    }

    private int findIndexOfMaxNum(int startIndex, char[] number) {
        return IntStream.range(startIndex, number.length)
                .boxed()
                .reduce((a, b) -> number[a] > number[b] ? a : b)
                .orElseThrow(() -> new NoSuchElementException("최댓값이 없습니다."));
    }

    private void swap(int i, int j, char[] numbers) {
        char temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}

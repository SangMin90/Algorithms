package ddongman.doit.datastructure;

public class Sum {
    public long solution(int n, String numbers) {
        return numbers.chars()
                .map(number -> number - '0')
                .sum();
    }
}

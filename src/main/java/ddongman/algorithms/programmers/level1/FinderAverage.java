package ddongman.algorithms.programmers.level1;

public class FinderAverage {
    public double solution(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return (double) sum / arr.length;
    }
}

package ddongman.doit.euclidean;

import java.util.List;
import java.util.stream.IntStream;

public class LCM {

    private int[] lcm;

    public int[] solution(int t, int[][] arr) {
        init(t);

        for (int i = 0; i < t; i++) {
            lcm[i] = findLcmBetween(arr[i][0], arr[i][1]);
        }

        return lcm;
    }

    private int findLcmBetween(int i, int j) {
        int gcd = findGcdBetween(i, j);
        return i * j / gcd;
    }

    private int findGcdBetween(int i, int j) {
        List<Integer> factorsOfI = findFactors(i);
        List<Integer> factorsOfJ = findFactors(j);

        return factorsOfI.stream()
                .filter(factorsOfJ::contains)
                .max(Integer::compareTo)
                .orElseThrow(() -> new RuntimeException("최대공약수를 찾을 수 없습니다."));
    }

    private List<Integer> findFactors(int i) {
        return IntStream.rangeClosed(1, i)
                .filter(num -> i % num == 0)
                .boxed()
                .toList();
    }

    private void init(int n) {
        lcm = new int[n];
    }
}

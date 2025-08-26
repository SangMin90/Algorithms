package ddongman.algorithms.doit.euclidean;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Cocktail {
    public int[] solution(int n, int[][] arr) {
        Ratio[][] ratio = getRatioArray(n, arr);

        return findRatioOfCocktail(ratio);
    }

    private int[] findRatioOfCocktail(Ratio[][] ratio) {
        // 마지막 재료에 대한 이외의 재료 비율을 모두 표시
        if (!isConvertedRatio(ratio)) {
            convertRatio(ratio);
        }

        // 공통 분모
        int commonDominator = getCommonDominator(ratio);

        // 정규화(마지막 재료에 대한 비율을 정수로 표현)
        int[] normalizedRatio = normalizeRatio(ratio, commonDominator);

        // 최소값에 대한 약수 구하기
        List<Integer> factors = findFactors(
                Arrays.stream(normalizedRatio)
                        .min()
                        .orElseThrow(
                                () -> new RuntimeException("최솟값이 존재하지 않습니다.")
                        )
        );

        // 최대공약수 구하기
        Integer gcd = factors.stream()
                .filter(f ->
                        Arrays.stream(normalizedRatio).allMatch(n -> n % f == 0)
                )
                .max(Integer::compareTo)
                .orElseThrow(
                        () -> new RuntimeException("Couldn't find common dominator")
                );

        return Arrays.stream(normalizedRatio)
                .map(r -> r / gcd)
                .toArray();
    }

    private int[] normalizeRatio(Ratio[][] ratio, int commonDominator) {
        return Arrays.stream(ratio)
                .mapToInt(r ->
                        r[r.length - 1].getP() * commonDominator / r[r.length - 1].getQ())
                .toArray();
    }

    private int getCommonDominator(Ratio[][] ratio) {
        int commonDominator = 1;
        for (Ratio[] r : ratio) {
            commonDominator *= r[r.length - 1].getQ();
        }

        return commonDominator;
    }

    private void convertRatio(Ratio[][] ratio) {
        for (int i = 0; i < ratio.length; i++) {
            if (ratio[i][ratio.length - 1] == null) {
                for (int j = 0; j < ratio[i].length; j++) {
                    if (ratio[j][i] != null && ratio[j][ratio[j].length - 1] != null) {
                        ratio[i][ratio.length - 1] = new Ratio(
                                ratio[i][j].getP() * ratio[j][ratio.length - 1].getP(),
                                ratio[i][j].getQ() * ratio[j][ratio.length - 1].getQ());
                    }
                }
            }
        }
    }

    private Ratio[][] getRatioArray(int n, int[][] arr) {
        Ratio[][] ratio = new Ratio[n][n];

        for (int i = 0; i < n; i++) {
            ratio[i][i] = new Ratio(1, 1);
        }

        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            int p = arr[i][2];
            int q = arr[i][3];

            ratio[a][b] = new Ratio(p, q);
            ratio[b][a] = new Ratio(q, p);
        }

        return ratio;
    }

    private boolean isConvertedRatio(Ratio[][] ratio) {
        for (Ratio[] ratios : ratio) {
            if (ratios[ratio.length - 1] == null) {
                return false;
            }
        }

        return true;
    }

    class Ratio {

        private int p;
        private int q;

        public Ratio(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }

    private List<Integer> findFactors(int i) {
        return IntStream.rangeClosed(1, i)
                .filter(num -> i % num == 0)
                .boxed()
                .toList();
    }
}

package ddongman.doit.datastructure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class Average {

    public double solution(int n, int[] scores) {
        BigDecimal maxScore = BigDecimal.valueOf(
                Arrays.stream(scores)
                        .max()
                        .orElseThrow(
                                () -> new NullPointerException("점수가 존재하지 않습니다.")
                        )
        );

        BigDecimal totalScore = BigDecimal.valueOf(
                Arrays.stream(scores).asLongStream().sum()
        );

        BigDecimal totalCount = BigDecimal.valueOf(n);

        BigDecimal base = BigDecimal.valueOf(100);

        return totalScore.multiply(base)
                .divide(totalCount.multiply(maxScore), 10, RoundingMode.HALF_UP)
                .doubleValue();
    }
}

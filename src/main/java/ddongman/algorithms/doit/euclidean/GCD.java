package ddongman.algorithms.doit.euclidean;

import java.util.List;
import java.util.stream.LongStream;

public class GCD {
    public long solution(long n, long m) {
        if (n < m) {
            long temp = n;
            n = m;
            m = temp;
        }

        return convertToNum(findGcdBetween(n, m));
    }

    private long findGcdBetween(long n, long m) {
        long r = n % m;
        if (r == 0) {
            return m;
        }

        List<Long> factorsOfRemain = findFactors(r);
        return factorsOfRemain.stream().filter(factor -> m % factor == 0).max(Long::compare)
                .orElseThrow(() -> new RuntimeException("약수가 존재하지 않습니다."));
    }

    private List<Long> findFactors(long i) {
        return LongStream.rangeClosed(1, i)
                .filter(num -> i % num == 0)
                .boxed()
                .toList();
    }

    private long convertToNum(long n) {
        long result = 0;
        long base = 1L;
        while (--n >= 0) {
            result += base;
            base *= 10L;
        }

        return result;
    }
}

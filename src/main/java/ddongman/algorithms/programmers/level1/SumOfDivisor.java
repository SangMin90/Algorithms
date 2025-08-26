package ddongman.algorithms.programmers.level1;

public class SumOfDivisor {
    public int solution(int n) {
        int answer = 0;
        for (int divisor=1;divisor*divisor<=n;divisor++) {
            if (n % divisor == 0) {
                if (divisor*divisor == n) {
                    answer += divisor;
                } else {
                    answer += divisor + (n/divisor);
                }
            }
        }
        return answer;
    }
}

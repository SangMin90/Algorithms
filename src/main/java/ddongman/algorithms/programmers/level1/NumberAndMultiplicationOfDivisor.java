package ddongman.algorithms.programmers.level1;

public class NumberAndMultiplicationOfDivisor {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i=left;i<=right;i++) {
            int numberOfDivisor = getNumberOfDivisor(i);
            if (numberOfDivisor % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    static int getNumberOfDivisor(int number) {
        int count = 0;
        for (int divisor=1;divisor*divisor<=number;divisor++) {
            if (number % divisor == 0) {
                if (divisor*divisor == number) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }
}

package ddongman.algorithms.programmers.level1;

public class FinderPrimeNumber {
    public int solution(int n) {
        int[] primeNumber = new int[1000001];
        primeNumber[0] = primeNumber[1] = 1;
        for (int i=2;i*i<=primeNumber.length;i++) {
            for (int j=2*i;j<primeNumber.length;j+=i) {
                if (primeNumber[j] == 0) {
                    primeNumber[j] = 1;
                }
            }
        }
        int answer = 0;
        for (int i=0;i<=n;i++) {
            if (primeNumber[i] == 0) {
                answer++;
            }
        }
        return answer;
    }
}

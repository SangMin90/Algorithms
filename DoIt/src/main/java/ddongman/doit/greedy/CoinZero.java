package ddongman.doit.greedy;

public class CoinZero {
    public int solution(int n, int k, int[] coins) {
        int result = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            result += k / coins[i];
            k %= coins[i];
        }

        return result;
    }
}

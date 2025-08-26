package ddongman.algorithms.programmers.level1;

public class InsufficientMoneyCalculation {
    public long solution(long price, long money, int count) {
        long totalPrice = 0;

        for (int i=1;i<=count;i++) {
            totalPrice += price * i;
        }

        return totalPrice > money ? totalPrice - money : 0;
    }
}

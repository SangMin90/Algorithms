public class InsufficientMoneyCalculation {
    public long solution(int price, int money, int count) {
        long totalPrice = 0;

        for (int i=1;i<=count;i++) {
            totalPrice += price * i;
        }

        long answer = totalPrice > money ? totalPrice-money:0;

        return answer;
    }
}

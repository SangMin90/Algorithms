package ddongman.algorithms.doit.dp;

import java.util.ArrayList;
import java.util.List;

public class ConsultantManager {

    private final int N;
    private final int[] dp;
    private final List<Consultation> consultations = new ArrayList<>();

    public ConsultantManager(int N) {
        this.N = N;
        dp = new int[N + 2];
    }

    public void addConsultation(int period, int profit) {
        consultations.add(new Consultation(period, profit));
    }

    public int calculateMaxProfits() {

        for (int startDay = N; startDay >= 1; startDay--) {

            if (isPossible(startDay)) {
                dp[startDay] = Math.max(dp[startDay + 1], dp[nextDay(startDay)] + profit(startDay));
                continue;
            }

            dp[startDay] = dp[startDay + 1];
        }

        return dp[1];
    }

    private boolean isPossible(int startDay) {
        Consultation consultation = consultations.get(startDay - 1);
        return startDay + consultation.getPeriod() - 1 <= N;
    }

    private int nextDay(int startDay) {
        return startDay + consultations.get(startDay - 1).getPeriod();
    }

    private int profit(int startDay) {
        return consultations.get(startDay - 1).getProfit();
    }

    static class Consultation {

        private final int period;
        private final int profit;

        public Consultation(int period, int profit) {
            this.period = period;
            this.profit = profit;
        }

        public int getPeriod() {
            return period;
        }

        public int getProfit() {
            return profit;
        }
    }
}

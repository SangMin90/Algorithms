package ddongman.algorithms.doit.combination;

public class Box {

    private int totalCount;
    private final int[] peddles;

    public Box(int[] peddles) {
        this.peddles = peddles.clone();
        for (int count : peddles) {
            totalCount += count;
        }
    }

    public double calculateProbabilityOfSameColor(int K) {
        return ProbabilityCalculator.calculateProbabilityOfSameColor(peddles, totalCount, K);
    }

    private static class ProbabilityCalculator {

        static double calculateProbabilityOfSameColor(int[] peddles, int N, int K) {

            double probability = 0;

            for (int i = 0; i < peddles.length; i++) {
                double prob = 1.0;
                for (int j = 0; j < K; j++) {
                    prob *= (double) (peddles[i] - j) / (N - j);
                }

                probability += prob;
            }

            return probability;
        }
    }
}

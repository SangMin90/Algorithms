package ddongman.algorithms.etc.past.knapsack;

import java.util.Arrays;

public class MultipleKnapsack {

    private final int N;
    private final int M;
    private final int K;
    private final Item[] items;

    private int best;

    private final static double epsilon = 1e-10;

    public MultipleKnapsack(Item[] items, int K, int M) {

        N = items.length;
        this.M = M;
        this.K = K;
        this.items = items;
    }

    public int maxValue() {

        Arrays.sort(items);

        int[] knapsacks = new int[K];
        Arrays.fill(knapsacks, M);

        dfs(0, knapsacks, 0);

        return best;
    }

    private void dfs(int index, int[] knapsacks, int currentValue) {

        double upperBound = fractionalBound(index, knapsacks, currentValue);

        if (!isGreaterThanBest(upperBound)) {
            return;
        }

        if (index == N) {
            best = Math.max(best, currentValue);
            return;
        }

        Item item = items[index];

        for (int i = 0; i < K; i++) {

            if (knapsacks[i] >= item.weight) {
                knapsacks[i] -= item.weight;
                dfs(index + 1, knapsacks, currentValue + item.value);
                knapsacks[i] += item.weight;
            }
        }

        dfs(index + 1, knapsacks, currentValue);
    }

    private boolean isGreaterThanBest(double bound) {

        return bound > (double) best + epsilon;
    }

    private double fractionalBound(int index, int[] knapsacks, int currentValue) {

        double upperBound = currentValue;

        int remain = 0;
        for (int i = 0; i < K; i++) {
            remain += knapsacks[i];
        }

        for (int i = index; i < N; i++) {

            Item item = items[i];
            if (remain < item.weight) {
                upperBound += item.value * ((double) remain / item.weight);
                break;
            } else {
                upperBound += item.value;
                remain -= item.weight;
            }
        }

        return upperBound;
    }

    static class Item implements Comparable<Item> {

        private final int weight;
        private final int value;
        private final double rate;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.rate = (double) value / weight;
        }

        @Override
        public int compareTo(Item other) {

            if (Math.abs(this.rate - other.rate) < epsilon) {
                return 0;
            }

            return this.rate > other.rate ? -1 : 1;
        }
    }
}

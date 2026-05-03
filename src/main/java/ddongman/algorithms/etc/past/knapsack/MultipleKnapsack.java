package ddongman.algorithms.etc.past.knapsack;

import ddongman.algorithms.etc.past.domain.Item;

import java.util.Arrays;

import static ddongman.algorithms.constant.Constant.EPSILON;

public class MultipleKnapsack {

    private final int N;
    private final int M;
    private final int K;
    private final Item[] items;

    private int best;

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

            if (knapsacks[i] >= item.getWeight()) {
                knapsacks[i] -= item.getWeight();
                dfs(index + 1, knapsacks, currentValue + item.getValue());
                knapsacks[i] += item.getWeight();
            }
        }

        dfs(index + 1, knapsacks, currentValue);
    }

    private boolean isGreaterThanBest(double bound) {

        return bound > (double) best + EPSILON;
    }

    private double fractionalBound(int index, int[] knapsacks, int currentValue) {

        double upperBound = currentValue;

        int remain = 0;
        for (int i = 0; i < K; i++) {
            remain += knapsacks[i];
        }

        for (int i = index; i < N; i++) {

            Item item = items[i];
            if (remain < item.getWeight()) {
                upperBound += item.getValue() * ((double) remain / item.getWeight());
                break;
            } else {
                upperBound += item.getValue();
                remain -= item.getWeight();
            }
        }

        return upperBound;
    }
}

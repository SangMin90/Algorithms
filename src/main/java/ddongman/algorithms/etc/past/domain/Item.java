package ddongman.algorithms.etc.past.domain;

import static ddongman.algorithms.constant.Constant.EPSILON;

public class Item implements Comparable<Item> {

    private final int weight;
    private final int value;
    private final double rate;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
        this.rate = (double) value / weight;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Item other) {

        if (Math.abs(this.rate - other.rate) < EPSILON) {
            return 0;
        }

        return this.rate > other.rate ? -1 : 1;
    }
}
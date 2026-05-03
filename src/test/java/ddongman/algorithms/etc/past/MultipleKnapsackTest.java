package ddongman.algorithms.etc.past;

import ddongman.algorithms.etc.past.knapsack.MultipleKnapsack;
import org.junit.jupiter.api.Test;

import static ddongman.algorithms.etc.past.knapsack.MultipleKnapsack.*;
import static org.assertj.core.api.Assertions.*;

class MultipleKnapsackTest {

    private MultipleKnapsack sut;

    @Test
    void case1() {

        int N = 5;
        int K = 2;
        int M = 5;
        Item[] items = new Item[]{
                new Item(4, 5),
                new Item(3, 4),
                new Item(2, 1),
                new Item(5, 7),
                new Item(1, 1),

        };
        sut = new MultipleKnapsack(items, K, M);

        int result = sut.maxValue();

        assertThat(result).isEqualTo(13);
    }

    @Test
    void case2() {

        int N = 10;
        int K = 3;
        int M = 7;
        Item[] items = new Item[]{
                new Item(4, 5),
                new Item(3, 4),
                new Item(2, 1),
                new Item(5, 7),
                new Item(1, 1),
                new Item(7, 8),
                new Item(8, 6),
                new Item(3, 3),
                new Item(4, 3),
                new Item(5, 4),

        };
        sut = new MultipleKnapsack(items, K, M);

        int result = sut.maxValue();

        assertThat(result).isEqualTo(25);
    }

}
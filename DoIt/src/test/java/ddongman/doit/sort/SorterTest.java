package ddongman.doit.sort;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterTest {
    private Sorter sut;

    @BeforeEach
    void setUp() {
        sut = new Sorter();
    }

    @Test
    void bubbleSort_case1() {
        int[] numbers = new int[]{5, 2, 3, 4, 1};

        int[] result = sut.bubbleSort(numbers);

        Assertions.assertThat(result).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }
}
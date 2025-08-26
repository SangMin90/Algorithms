package ddongman.algorithms.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegerPartitionTest {

    private IntegerPartition sut;

    @BeforeEach
    void setUp() {
        sut = new IntegerPartition();
    }

    @Test
    void case1() {
        int n = 10;
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int result = sut.solution(n, numbers);

        Assertions.assertThat(result).isEqualTo(8);
    }
}
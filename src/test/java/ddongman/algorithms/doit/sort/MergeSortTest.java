package ddongman.algorithms.doit.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortTest {

    private MergeSort sut;

    @BeforeEach
    void setUp() {
        sut = new MergeSort();
    }

    @Test
    void case1() {
        int n = 5;
        int[] arr = {5, 4, 3, 2, 1};

        int[] result = sut.solution(n, arr);

        assertThat(result).isEqualTo(new int[]{1, 2, 3, 4, 5});
    }
}
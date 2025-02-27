package ddongman.doit.datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbsHeapTest {

    private AbsHeap sut;

    @BeforeEach
    void setUp() {
        sut = new AbsHeap();
    }

    @Test
    void case1() {
        int n = 18;
        int[] numbers = new int[]{1, -1, 0, 0, 0, 1, 1, -1, -1, 2, -2, 0, 0, 0, 0, 0, 0, 0};

        int[] result = sut.solution(n, numbers);

        assertThat(result).isEqualTo(new int[]{-1, 1, 0, -1, -1, 1, 1, -2, 2, 0});
    }
}
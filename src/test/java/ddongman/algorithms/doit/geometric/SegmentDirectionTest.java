package ddongman.algorithms.doit.geometric;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SegmentDirectionTest {

    private SegmentDirection sut;

    @BeforeEach
    void setUp() {
        sut = new SegmentDirection();
    }

    @Test
    void case1() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}, {7, 3}});

        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    void case2() {
        int result = sut.solution(new int[][]{{1, 1}, {3, 3}, {5, 5}});

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void case3() {
        int result = sut.solution(new int[][]{{1, 1}, {7, 3}, {5, 5}});

        Assertions.assertThat(result).isEqualTo(1);
    }
}
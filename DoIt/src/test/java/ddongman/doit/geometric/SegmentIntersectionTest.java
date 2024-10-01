package ddongman.doit.geometric;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SegmentIntersectionTest {

    private SegmentIntersection sut;

    @BeforeEach
    void setUp() {
        sut = new SegmentIntersection();
    }

    @Test
    void case1() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{1, 5}, {5, 1}});
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{6, 10}, {10, 6}});
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void case3() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{5, 5}, {1, 1}});
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{3, 3}, {5, 5}});
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case5() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{3, 3}, {1, 3}});
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case6() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{5, 5}, {9, 9}});
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case7() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{6, 6}, {9, 9}});
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void case8() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{5, 5}, {1, 5}});
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    void case9() {
        int result = sut.solution(new int[][]{{1, 1}, {5, 5}}, new int[][]{{6, 6}, {1, 5}});
        Assertions.assertThat(result).isEqualTo(0);
    }
}
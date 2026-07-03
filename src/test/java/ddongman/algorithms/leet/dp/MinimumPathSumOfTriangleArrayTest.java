package ddongman.algorithms.leet.dp;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumPathSumOfTriangleArrayTest {

    private MinimumPathSumOfTriangleArray sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumPathSumOfTriangleArray();
    }

    @Test
    void case1() {
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7),
            List.of(4, 1, 8, 3));

//        int result = sut.minimumTotal(triangle);
//        int result = sut.minimumTotal2(triangle);
        int result = sut.minimumTotal3(triangle);

        assertThat(result).isEqualTo(11);
    }

    @Test
    void case2() {
        List<List<Integer>> triangle = List.of(List.of(-10));

//        int result = sut.minimumTotal(triangle);
//        int result = sut.minimumTotal2(triangle);
        int result = sut.minimumTotal3(triangle);

        assertThat(result).isEqualTo(-10);
    }
}
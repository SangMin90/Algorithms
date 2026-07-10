package ddongman.algorithms.leet.matrix;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpiralMatrixTest {

    private SpiralMatrix sut;

    @BeforeEach
    public void setUp() {
        sut = new SpiralMatrix();
    }

    @Test
    void case1() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

//        List<Integer> result = sut.spiralOrder(matrix);
        List<Integer> result = sut.spiralOrder2(matrix);

        assertThat(result).isEqualTo(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5));
    }

    @Test
    void case2() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};

//        List<Integer> result = sut.spiralOrder(matrix);
        List<Integer> result = sut.spiralOrder2(matrix);

        assertThat(result).isEqualTo(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7));
    }

    @Test
    void case3() {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16},
            {17, 18, 19, 20}, {21, 22, 23, 24}};

//        List<Integer> result = sut.spiralOrder(matrix);
        List<Integer> result = sut.spiralOrder2(matrix);

        assertThat(result).isEqualTo(
            List.of(1, 2, 3, 4, 8, 12, 16, 20, 24, 23, 22, 21, 17, 13, 9, 5, 6, 7, 11, 15, 19, 18,
                14, 10));
    }
}
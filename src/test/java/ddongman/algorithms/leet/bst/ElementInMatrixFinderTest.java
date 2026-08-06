package ddongman.algorithms.leet.bst;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementInMatrixFinderTest {

    private ElementInMatrixFinder sut;

    @BeforeEach
    void setUp() {
        sut = new ElementInMatrixFinder();
    }

    @Test
    void case1() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        int[][] matrix = {{1}};
        int target = 0;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isFalse();
    }

    @Test
    void case4() {
        int[][] matrix = {{1, 3}};
        int target = 3;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isTrue();
    }

    @Test
    void case5() {
        int[][] matrix = {{1}};
        int target = 2;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isFalse();
    }

    @Test
    void case6() {
        int[][] matrix = {{1}, {3}};
        int target = 0;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isFalse();
    }

    @Test
    void case7() {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        int target = 11;

//        boolean result = sut.searchMatrix(matrix, target);
        boolean result = sut.searchMatrix2(matrix, target);

        assertThat(result).isTrue();
    }
}
package ddongman.algorithms.leet.twopointer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ContainerWithMostWaterFinderTest {

    private ContainerWithMostWaterFinder sut;

    @Test
    void case1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        sut = new ContainerWithMostWaterFinder();

//        int result = sut.maxArea(height);
        int result = sut.maxArea2(height);

        assertThat(result).isEqualTo(49);
    }

    @Test
    void case2() {
        int[] height = {1, 1};
        sut = new ContainerWithMostWaterFinder();

//        int result = sut.maxArea(height);
        int result = sut.maxArea2(height);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int[] height = {0, 1, 2, 0};
        sut = new ContainerWithMostWaterFinder();

//        int result = sut.maxArea(height);
        int result = sut.maxArea2(height);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        int[] height = {1, 2, 4, 3};
        sut = new ContainerWithMostWaterFinder();

//        int result = sut.maxArea(height);
        int result = sut.maxArea2(height);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case5() {
        int[] height = {3, 6, 1};
        sut = new ContainerWithMostWaterFinder();

//        int result = sut.maxArea(height);
        int result = sut.maxArea2(height);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case6() {
        int[] height = {1, 2, 3, 1000, 9};
        sut = new ContainerWithMostWaterFinder();

//        int result = sut.maxArea(height);
        int result = sut.maxArea2(height);

        assertThat(result).isEqualTo(9);
    }
}
package ddongman.algorithms.leet.contest.weekly517;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IntegerArrayHandlerTest {

    private IntegerArrayHandler sut;

    @Test
    void case1() {
        int[] nums = {1,2,2,1};
        sut = new IntegerArrayHandler();

        int result = sut.countSpecialIntegers(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        int[] nums = {3, 3, 1, 2, 2, 1};
        sut = new IntegerArrayHandler();

        int result = sut.countSpecialIntegers(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int[] nums = {22};
        sut = new IntegerArrayHandler();

        int result = sut.countSpecialIntegers(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        int[] nums = {34, 34};
        sut = new IntegerArrayHandler();

        int result = sut.countSpecialIntegers(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case5() {
        int[] nums = {9, 62, 62, 75, 75, 75, 96, 96, 96, 96, 96, 96, 96, 96, 9, 9, 9, 9, 9, 75, 75,
            75, 9, 9};
        sut = new IntegerArrayHandler();

        int result = sut.countSpecialIntegers(nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case6() {
        long[] nums = {231L};
        sut = new IntegerArrayHandler();

        int result = sut.sumDecoded(nums);

        assertThat(result).isEqualTo(8);
    }

    @Test
    void case7() {
        long[] nums = {2522L, 2101L};
        sut = new IntegerArrayHandler();

        int result = sut.sumDecoded(nums);

        assertThat(result).isEqualTo(1649);
    }

    @Test
    void case8() {
        long[] nums = {2301L};
        sut = new IntegerArrayHandler();

        int result = sut.sumDecoded(nums);

        assertThat(result).isEqualTo(73741817);
    }

    @Test
    void case9() {
        long[] nums = {59412L};
        sut = new IntegerArrayHandler();

        int result = sut.sumDecoded(nums);

        assertThat(result).isEqualTo(44723187);
    }

    @Test
    void case10() {
        long[] nums = {626736720942L, 34883631L};
        sut = new IntegerArrayHandler();

        int result = sut.sumDecoded(nums);

        assertThat(result).isEqualTo(993083755);
    }
}
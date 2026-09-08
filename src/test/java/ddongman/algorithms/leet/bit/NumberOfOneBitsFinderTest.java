package ddongman.algorithms.leet.bit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NumberOfOneBitsFinderTest {

    private NumberOfOneBitsFinder sut;

    @Test
    void case1() {
        int n = 11;
        sut = new NumberOfOneBitsFinder();

        int result = sut.hammingWeight(n);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        int n = 128;
        sut = new NumberOfOneBitsFinder();

        int result = sut.hammingWeight(n);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        int n = 2147483645;
        sut = new NumberOfOneBitsFinder();

        int result = sut.hammingWeight(n);

        assertThat(result).isEqualTo(30);
    }

    @Test
    void case4() {
        int n = 1;
        sut = new NumberOfOneBitsFinder();

        int result = sut.hammingWeight(n);

        assertThat(result).isEqualTo(1);
    }
}
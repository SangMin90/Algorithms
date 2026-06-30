package ddongman.algorithms.leet.bit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryCalculatorTest {

    private BinaryCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new BinaryCalculator();
    }

    @Test
    void case1() {
        String a = "11", b = "1";

//        String result = sut.addBinary(a, b);
        String result = sut.addBinary2(a, b);

        assertThat(result).isEqualTo("100");
    }

    @Test
    void case2() {
        String a = "1010", b = "1011";

//        String result = sut.addBinary(a, b);
        String result = sut.addBinary2(a, b);

        assertThat(result).isEqualTo("10101");
    }

    @Test
    void case3() {
        String a =     "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

//        String result = sut.addBinary(a, b);
        String result = sut.addBinary2(a, b);

        assertThat(result).isEqualTo("110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000");
    }
}
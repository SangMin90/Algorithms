package ddongman.algorithms.leet.bit;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BitReverserTest {

    private BitReverser sut;

    @BeforeEach
    void setUp() {
        sut = new BitReverser();
    }

    @Test
    void case1() {
        int n = 43261596;

//        int result = sut.reverseBits(n);
//        int result = sut.reverseBits2(n);
//        int result = sut.reverseBits3(n);
        int result = sut.reverseBits4(n);

        assertThat(result).isEqualTo(964176192);
    }

    @Test
    void case2() {
        int n = 2147483644;

//        int result = sut.reverseBits(n);
//        int result = sut.reverseBits2(n);
//        int result = sut.reverseBits3(n);
        int result = sut.reverseBits4(n);

        assertThat(result).isEqualTo(1073741822);
    }
}
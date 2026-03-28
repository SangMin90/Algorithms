package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DictionaryTest {

    private Dictionary sut;

    @Test
    void case1() {
        int N = 2;
        int M = 2;
        int K = 2;
        sut = new Dictionary(N, M);

        String result = sut.findKthWord(K);

        assertThat(result).isEqualTo("azaz");
    }

    @Test
    void case2() {
        int N = 2;
        int M = 2;
        int K = 6;
        sut = new Dictionary(N, M);

        String result = sut.findKthWord(K);

        assertThat(result).isEqualTo("zzaa");
    }

    @Test
    void case3() {
        int N = 10;
        int M = 10;
        int K = 1000000000;
        sut = new Dictionary(N, M);

        String result = sut.findKthWord(K);

        assertThat(result).isEqualTo("-1");
    }

    @Test
    void case4() {
        int N = 7;
        int M = 4;
        int K = 47;
        sut = new Dictionary(N, M);

        String result = sut.findKthWord(K);

        assertThat(result).isEqualTo("aaazazaazaz");
    }
}
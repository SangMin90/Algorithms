package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationTest {

    private Permutation sut;

    @Test
    void case1() {
        int N = 4;
        long K = 3;
        sut = new Permutation(N);

        int[] result = sut.findKthPermutation(K, N);

        assertThat(result).isEqualTo(new int[]{1, 3, 2, 4});
    }

    @Test
    void case2() {
        int N = 4;
        long K = 12;
        sut = new Permutation(N);

        int[] result = sut.findKthPermutation(K, N);

        assertThat(result).isEqualTo(new int[]{2, 4, 3, 1});
    }

    @Test
    void case3() {
        int N = 4;
        int[] permutation = new int[]{1, 3, 2, 4};
        sut = new Permutation(N);

        long result = sut.findOrderOf(permutation);

        assertThat(result).isEqualTo(3L);
    }

    @Test
    void case4() {
        int N = 4;
        int[] permutation = new int[]{2, 1, 4, 3};
        sut = new Permutation(N);

        long result = sut.findOrderOf(permutation);

        assertThat(result).isEqualTo(8L);
    }
}
package ddongman.doit.euclidean;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LCMTest {

    private LCM sut;

    @BeforeEach
    void setUp() {
        sut = new LCM();
    }

    @Test
    void case1() {
        int t = 3;
        int[][] arr = new int[][]{{1, 45000}, {6, 10}, {13, 17}};

        int[] result = sut.solution(3, arr);

        assertThat(result).isEqualTo(new int[]{45000, 30, 221});
    }
}
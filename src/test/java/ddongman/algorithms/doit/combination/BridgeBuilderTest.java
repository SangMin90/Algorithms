package ddongman.algorithms.doit.combination;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeBuilderTest {

    private static BridgeBuilder sut;

    @BeforeAll
    static void setUp() {
        sut = new BridgeBuilder(30);
    }

    @Test
    void case1() {
        int N = 2;
        int M = 2;

        int count = sut.countBridgeWays(N, M);

        assertThat(count).isEqualTo(1);
    }

    @Test
    void case2() {
        int N = 1;
        int M = 5;

        int count = sut.countBridgeWays(N, M);

        assertThat(count).isEqualTo(5);
    }

    @Test
    void case3() {
        int N = 13;
        int M = 29;

        int count = sut.countBridgeWays(N, M);

        assertThat(count).isEqualTo(67863915);
    }
}
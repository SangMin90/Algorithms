package ddongman.algorithms.leet.dp;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StairClimberTest {

    private StairClimber sut;

    @BeforeEach
    void setUp() {
        sut = new StairClimber();
    }

    @Test
    void case1() {
        int n = 2;

        int result = sut.climbStairs(n);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int n = 3;

        int result = sut.climbStairs(n);

        assertThat(result).isEqualTo(3);
    }
}
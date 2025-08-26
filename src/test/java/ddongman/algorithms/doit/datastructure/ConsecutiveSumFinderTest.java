package ddongman.algorithms.doit.datastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsecutiveSumFinderTest {

    private ConsecutiveSumFinder sut;

    @BeforeEach
    void setUp() {
        sut = new ConsecutiveSumFinder();
    }

    @Test
    void case1() {
        int n = 15;

        int result = sut.solution(15);

        Assertions.assertThat(result).isEqualTo(4);
    }
}
package ddongman.algorithms.doit.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RoomAllocationTest {

    private RoomAllocation sut;

    @BeforeEach
    void setUp() {
        sut = new RoomAllocation();
    }

    @Test
    void case1() {
        int n = 11;
        long[][] periods = new long[][]{
                {1, 4},
                {3, 5},
                {0, 6},
                {5, 7},
                {3, 8},
                {5, 9},
                {6, 10},
                {8, 11},
                {8, 12},
                {2, 13},
                {12, 14},
        };

        int result = sut.solution(n, periods);

        assertThat(result).isEqualTo(4);
    }
}
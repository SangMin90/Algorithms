package ddongman.algorithms.doit.graph.unionfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ddongman.algorithms.doit.graph.unionfind.TravelPlan.*;
import static ddongman.algorithms.doit.graph.unionfind.TravelPlan.YN.YES;

class TravelPlanTest {

    private TravelPlan sut;

    @BeforeEach
    void setUp() {
        sut = new TravelPlan();
    }

    @Test
    void case1() {
        int N = 3;
        int M = 3;
        int[][] link = new int[][]{
                {0, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        int[] plan = new int[]{1, 2, 3};

        YN result = sut.solution(N, M, link, plan);

        Assertions.assertThat(result).isEqualTo(YES);
    }
}
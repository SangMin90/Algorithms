package ddongman.algorithms.doit.graph;

import ddongman.algorithms.doit.graph.BiPartite.Edge;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ddongman.algorithms.doit.graph.BiPartite.*;
import static ddongman.algorithms.doit.graph.BiPartite.YN.NO;
import static ddongman.algorithms.doit.graph.BiPartite.YN.YES;
import static org.assertj.core.api.Assertions.assertThat;

class BiPartiteTest {

    private BiPartite sut;

    @BeforeEach
    void setUp() {
        sut = new BiPartite();
    }

    @Test
    void case1() {
        int V = 3;
        Edge[] graph = new Edge[]{
                new Edge(1, 3),
                new Edge(2, 3),
        };

        YN result = sut.solution(V, graph);

        assertThat(result).isEqualTo(YES);
    }

    @Test
    void case2() {
        int V = 4;
        Edge[] graph = new Edge[]{
                new Edge(1, 2),
                new Edge(2, 3),
                new Edge(3, 4),
                new Edge(4, 2),
        };

        YN result = sut.solution(V, graph);

        assertThat(result).isEqualTo(NO);
    }
}
package ddongman.algorithms.doit.tree.binary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TreeTraversalTest {

    private TreeTraversal sut;

    @BeforeEach
    void setUp() {
        sut = new TreeTraversal();
    }

    @Test
    void case1() {
        int N = 7;
        String[][] edges = new String[][]{
                {"A", "B", "C"},
                {"B", "D", "."},
                {"C", "E", "F"},
                {"E", ".", "."},
                {"F", ".", "G"},
                {"D", ".", "."},
                {"G", ".", "."},
        };


        String[] result = sut.solution(N, edges);

        assertThat(result).isEqualTo(new String[]{
                "ABDCEFG",
                "DBAECFG",
                "DBEGFCA",
        });

    }
}
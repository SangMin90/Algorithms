package ddongman.algorithms.leet.divideNConquer;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.divideNConquer.domain.Node;
import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.Test;

class QuadTreeConstructorTest {

    private QuadTreeConstructor sut;

    @Test
    void case1() {
        int[][] grid = {{0, 1}, {1, 0}};
        sut = new QuadTreeConstructor();

        Node result = sut.construct(grid);

        assertThat(result).isEqualTo(
            new Node(true, false,
                new Node(false, true),
                new Node(true, true),
                new Node(true, true),
                new Node(false, true)
            )
        );
    }

    @Test
    void case2() {
        int[][] grid = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        sut = new QuadTreeConstructor();

        Node result = sut.construct(grid);

        assertThat(result).isEqualTo(
            new Node(true, false,
                new Node(true, true),
                new Node(true, false,
                    new Node(false, true),
                    new Node(false, true),
                    new Node(true, true),
                    new Node(true, true)
                ),
                new Node(true, true),
                new Node(false, true)
            )
        );
    }

    @Test
    void case3() {
        int[][] grid = {{1,1,0,0},{0,0,1,1},{1,1,0,0},{0,0,1,1}};
        sut = new QuadTreeConstructor();

        Node result = sut.construct(grid);

        assertThat(result).isEqualTo(
            new Node(true, false,
                new Node(true, false,
                    new Node(true, true),
                    new Node(true, true),
                    new Node(false, true),
                    new Node(false, true)
                ),
                new Node(true, false,
                    new Node(false, true),
                    new Node(false, true),
                    new Node(true, true),
                    new Node(true, true)
                ),
                new Node(true, false,
                    new Node(true, true),
                    new Node(true, true),
                    new Node(false, true),
                    new Node(false, true)
                ),
                new Node(true, false,
                    new Node(false, true),
                    new Node(false, true),
                    new Node(true, true),
                    new Node(true, true)
                )
            )
        );
    }
}
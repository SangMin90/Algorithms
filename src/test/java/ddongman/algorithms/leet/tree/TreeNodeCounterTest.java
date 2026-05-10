package ddongman.algorithms.leet.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ddongman.algorithms.leet.tree.domain.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeCounterTest {

    private TreeNodeCounter sut;

    @BeforeEach
    void setUp() {
        sut = new TreeNodeCounter();
    }

    @Test
    void case1() {
        int[] root = {1, 2, 3, 4, 5, 6};
        TreeNode rootNode = new TreeNode(
                root[0],
                new TreeNode(
                        root[1],
                        new TreeNode(
                                root[3]
                        ),
                        new TreeNode(
                                root[4]
                        )
                ),
                new TreeNode(
                        root[2],
                        new TreeNode(
                                root[5]
                        ),
                        null
                )
        );

        int result = sut.countNodesWithDFS(rootNode);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case2() {
        TreeNode rootNode = null;

        int result = sut.countNodesWithDFS(rootNode);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case3() {
        TreeNode rootNode = new TreeNode(1);

        int result = sut.countNodesWithDFS(rootNode);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        int[] root = {1, 2, 3, 4, 5, 6};
        TreeNode rootNode = new TreeNode(
                root[0],
                new TreeNode(
                        root[1],
                        new TreeNode(
                                root[3]
                        ),
                        new TreeNode(
                                root[4]
                        )
                ),
                new TreeNode(
                        root[2],
                        new TreeNode(
                                root[5]
                        ),
                        null
                )
        );

        int result = sut.countNodesWithHeight(rootNode);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case5() {
        TreeNode rootNode = null;

        int result = sut.countNodesWithHeight(rootNode);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void case6() {
        TreeNode rootNode = new TreeNode(1);

        int result = sut.countNodesWithHeight(rootNode);

        assertThat(result).isEqualTo(1);
    }
}
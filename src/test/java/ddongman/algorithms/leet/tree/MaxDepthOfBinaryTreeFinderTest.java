package ddongman.algorithms.leet.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxDepthOfBinaryTreeFinderTest {

    private MaxDepthOfBinaryTreeFinder sut;

    @BeforeEach
    void setUp() {
        sut = new MaxDepthOfBinaryTreeFinder();
    }

    @Test
    void case1() {
        TreeNode treeNode = new TreeNode(
            3,
            new TreeNode(9),
            new TreeNode(
                20,
                new TreeNode(15),
                new TreeNode(7)
            )
        );

        int result = sut.maxDepth(treeNode);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        TreeNode treeNode = new TreeNode(
            1,
            null,
            new TreeNode(2)
        );

        int result = sut.maxDepth(treeNode);

        assertThat(result).isEqualTo(2);
    }
}
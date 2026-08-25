package ddongman.algorithms.leet.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.Test;

class BinaryTreeInverterTest {

    private BinaryTreeInverter sut;

    @Test
    void case1() {
        TreeNode root = new TreeNode(4,
            new TreeNode(2, new TreeNode(1), new TreeNode(3)),
            new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        sut = new BinaryTreeInverter();

        TreeNode result = sut.invertTree(root);

        assertThat(result).isEqualTo(
            new TreeNode(4,
                new TreeNode(7, new TreeNode(9), new TreeNode(6)),
                new TreeNode(2, new TreeNode(3), new TreeNode(1))
            )
        );
    }
    
    @Test
    void case2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        sut = new BinaryTreeInverter();

        TreeNode result = sut.invertTree(root);

        assertThat(result).isEqualTo(
            new TreeNode(2, new TreeNode(3), new TreeNode(1))
        );
    }

    @Test
    void case3() {
        TreeNode root = null;
        sut = new BinaryTreeInverter();

        TreeNode result = sut.invertTree(root);

        assertThat(result).isNull();
    }
}
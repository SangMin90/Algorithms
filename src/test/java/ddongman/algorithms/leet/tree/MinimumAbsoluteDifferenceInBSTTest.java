package ddongman.algorithms.leet.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MinimumAbsoluteDifferenceInBSTTest {

    private MinimumAbsoluteDifferenceInBST sut;

    @BeforeEach
    void setUp() {
        sut = new MinimumAbsoluteDifferenceInBST();
    }

    @Test
    void case1() {
        TreeNode treeNode = new TreeNode(
            4,
            new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
            ),
            new TreeNode(6)
        );

//        int result = sut.getMinimumDifference(treeNode);
        int result = sut.getMinimumDifference2(treeNode);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        TreeNode root = new TreeNode(
            1,
            new TreeNode(0),
            new TreeNode(
                48,
                new TreeNode(12),
                new TreeNode(49)
            )
        );

//        int result = sut.getMinimumDifference(root);
        int result = sut.getMinimumDifference2(root);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        TreeNode root = new TreeNode(
            5,
            new TreeNode(4),
            new TreeNode(7)
        );

//        int result = sut.getMinimumDifference(root);
        int result = sut.getMinimumDifference2(root);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case4() {
        TreeNode root = new TreeNode(
            100000,
            new TreeNode(0),
            null
        );

//        int result = sut.getMinimumDifference(root);
        int result = sut.getMinimumDifference2(root);

        assertThat(result).isEqualTo(100000);
    }

    @Test
    void case5() {
        TreeNode root = new TreeNode(
            236,
            new TreeNode(
                104,
                null,
                new TreeNode(227)
            ),
            new TreeNode(
                701,
                null,
                new TreeNode(911)
            )
        );

//        int result = sut.getMinimumDifference(root);
        int result = sut.getMinimumDifference2(root);

        assertThat(result).isEqualTo(9);
    }
}
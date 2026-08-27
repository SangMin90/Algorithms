package ddongman.algorithms.leet.bst;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.Test;

class BinarySearchTreeValidatorTest {

    private BinarySearchTreeValidator sut;

    @Test
    void case1() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        sut = new BinarySearchTreeValidator();

//        boolean result = sut.isValidBST(root);
//        boolean result = sut.isValidBST2(root);
        boolean result = sut.isValidBST3(root);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        TreeNode root = new TreeNode(
            5,
            new TreeNode(1),
            new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        sut = new BinarySearchTreeValidator();

//        boolean result = sut.isValidBST(root);
//        boolean result = sut.isValidBST2(root);
        boolean result = sut.isValidBST3(root);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        sut = new BinarySearchTreeValidator();

//        boolean result = sut.isValidBST(root);
//        boolean result = sut.isValidBST2(root);
        boolean result = sut.isValidBST3(root);

        assertThat(result).isFalse();
    }

    @Test
    void case4() {
        TreeNode root = new TreeNode(5, new TreeNode(4),
            new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        sut = new BinarySearchTreeValidator();

//        boolean result = sut.isValidBST(root);
//        boolean result = sut.isValidBST2(root);
        boolean result = sut.isValidBST3(root);

        assertThat(result).isFalse();
    }

    @Test
    void case5() {
        TreeNode root = new TreeNode(32,
            new TreeNode(
                26,
                new TreeNode(19, null, new TreeNode(27)),
                null),
            new TreeNode(47, null, new TreeNode(56)));
        sut = new BinarySearchTreeValidator();

//        boolean result = sut.isValidBST(root);
//        boolean result = sut.isValidBST2(root);
        boolean result = sut.isValidBST3(root);

        assertThat(result).isFalse();
    }
}
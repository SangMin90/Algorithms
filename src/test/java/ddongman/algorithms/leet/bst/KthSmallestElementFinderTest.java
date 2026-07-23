package ddongman.algorithms.leet.bst;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KthSmallestElementFinderTest {

    private KthSmallestElementFinder sut;

    @BeforeEach
    void setUp() {
        sut = new KthSmallestElementFinder();
    }

    @Test
    void case1() {
        TreeNode root = new TreeNode(3,
            new TreeNode(1, null, new TreeNode(2)),
            new TreeNode(4));
        int k = 1;

//        int result = sut.kthSmallest(root, k);
        int result = sut.kthSmallest2(root, k);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case2() {
        TreeNode root = new TreeNode(5,
            new TreeNode(3,
                new TreeNode(2, new TreeNode(1), null),
                new TreeNode(4)),
            new TreeNode(6));
        int k = 3;

//        int result = sut.kthSmallest(root, k);
        int result = sut.kthSmallest2(root, k);

        assertThat(result).isEqualTo(3);
    }
}
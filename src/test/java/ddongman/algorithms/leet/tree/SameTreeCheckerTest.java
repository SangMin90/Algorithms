package ddongman.algorithms.leet.tree;

import static org.assertj.core.api.Assertions.*;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SameTreeCheckerTest {

    private SameTreeChecker sut;

    @BeforeEach
    void setUp() {
        sut = new SameTreeChecker();
    }

    @Test
    void case1() {
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        TreeNode q = new TreeNode(1,new TreeNode(2),new TreeNode(3));

        boolean result = sut.isSameTree(p, q);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        TreeNode p = new TreeNode(1,new TreeNode(2),null);
        TreeNode q = new TreeNode(1,null,new TreeNode(2));

        boolean result = sut.isSameTree(p, q);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        TreeNode p = new TreeNode(1,new TreeNode(2),new TreeNode(1));
        TreeNode q = new TreeNode(1,new TreeNode(1),new TreeNode(2));

        boolean result = sut.isSameTree(p, q);

        assertThat(result).isFalse();
    }
}
package ddongman.algorithms.leet.tree;

import static org.assertj.core.api.Assertions.*;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RightmostNodeFinderTest {

    private RightmostNodeFinder sut;

    @BeforeEach
    void setUp() {
        sut = new RightmostNodeFinder();
    }

    @Test
    void case1() {
        TreeNode treeNode = new TreeNode(
            1,
            new TreeNode(
                2,
                null,
                new TreeNode(5)
            ),
            new TreeNode(
                3,
                null,
                new TreeNode(4)
            )
        );

        List<Integer> result = sut.rightSideView(treeNode);

        assertThat(result).containsExactly(1, 3, 4);
    }

    @Test
    void case2() {
        TreeNode treeNode = new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(
                    4,
                    new TreeNode(5),
                    null
                ),
                null
            ),
            new TreeNode(3)
        );

        List<Integer> result = sut.rightSideView(treeNode);

        assertThat(result).containsExactly(1, 3, 4, 5);
    }

    @Test
    void case3() {
        TreeNode treeNode = new TreeNode(
            1,
            null,
            new TreeNode(3)
        );

        List<Integer> result = sut.rightSideView(treeNode);

        assertThat(result).containsExactly(1, 3);
    }

    @Test
    void case4() {
        TreeNode treeNode = null;

        List<Integer> result = sut.rightSideView(treeNode);

        assertThat(result).containsExactly();
    }

    @Test
    void case5() {
        TreeNode treeNode = new TreeNode(
            1,
            new TreeNode(
                2,
                null,
                new TreeNode(5)
            ),
            new TreeNode(
                3,
                null,
                new TreeNode(4)
            )
        );

        List<Integer> result = sut.rightSideView2(treeNode);

        assertThat(result).containsExactly(1, 3, 4);
    }

    @Test
    void case6() {
        TreeNode treeNode = new TreeNode(
            1,
            new TreeNode(
                2,
                new TreeNode(
                    4,
                    new TreeNode(5),
                    null
                ),
                null
            ),
            new TreeNode(3)
        );

        List<Integer> result = sut.rightSideView2(treeNode);

        assertThat(result).containsExactly(1, 3, 4, 5);
    }

    @Test
    void case7() {
        TreeNode treeNode = new TreeNode(
            1,
            null,
            new TreeNode(3)
        );

        List<Integer> result = sut.rightSideView2(treeNode);

        assertThat(result).containsExactly(1, 3);
    }

    @Test
    void case8() {
        TreeNode treeNode = null;

        List<Integer> result = sut.rightSideView2(treeNode);

        assertThat(result).containsExactly();
    }
}
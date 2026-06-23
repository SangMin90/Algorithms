package ddongman.algorithms.leet.divideNConquer;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedArrayToBstConverterTest {

    private SortedArrayToBstConverter sut;

    @BeforeEach
    void setUp() {
        sut = new SortedArrayToBstConverter();
    }

    @Test
    void case1() {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode node = sut.sortedArrayToBST(nums);

        assertThat(node).isEqualTo(
            new TreeNode(
                0,
                new TreeNode(
                    -10,
                    null,
                    new TreeNode(-3)
                ),
                new TreeNode(
                    5,
                    null,
                    new TreeNode(9)
                )
            )
        );
    }

    @Test
    void case2() {
        int[] nums = {1, 3};

        TreeNode node = sut.sortedArrayToBST(nums);

        assertThat(node).isEqualTo(
            new TreeNode(
                1,
                null,
                new TreeNode(3)
            )
        );
    }
}
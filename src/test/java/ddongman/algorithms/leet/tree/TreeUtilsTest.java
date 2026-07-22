package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeUtilsTest {

    private TreeUtils sut;

    @BeforeEach
    public void setUp() {
        sut = new TreeUtils();
    }

    @Test
    void case1() {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7)
            )
        );

        List<Double> result = sut.averageOfLevels(root);

        Assertions.assertThat(result).containsExactly(3.00000,14.50000,11.00000);
    }
}
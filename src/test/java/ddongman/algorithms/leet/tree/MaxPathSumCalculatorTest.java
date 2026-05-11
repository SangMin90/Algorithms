package ddongman.algorithms.leet.tree;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaxPathSumCalculatorTest {

    private MaxPathSumCalculator sut;

    @BeforeEach
    void setUp() {
        sut = new MaxPathSumCalculator();
    }

    @Test
    void case1() {

        TreeNode rootNode = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        int result = sut.calculate(rootNode);

        assertThat(result).isEqualTo(6);
    }

    @Test
    void case2() {

        TreeNode rootNode = new TreeNode(
                -10,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        int result = sut.calculate(rootNode);

        assertThat(result).isEqualTo(42);
    }

    @Test
    void case3() {

        TreeNode rootNode = new TreeNode(
                1,
                new TreeNode(-2),
                new TreeNode(3)
        );

        int result = sut.calculate(rootNode);

        assertThat(result).isEqualTo(4);
    }
}
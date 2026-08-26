package ddongman.algorithms.leet.bfs;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.tree.domain.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

class BinaryTreeTraversalTest {

    private BinaryTreeTraversal sut;

    @Test
    void case1() {
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15), new TreeNode(7)
            )
        );
        sut = new BinaryTreeTraversal();

//        List<List<Integer>> result = sut.levelOrder(root);
//        List<List<Integer>> result = sut.levelOrder2(root);
        List<List<Integer>> result = sut.levelOrder3(root);

        assertThat(result).isEqualTo(List.of(List.of(3), List.of(9, 20),  List.of(15, 7)));
    }

    @Test
    void case2() {
        TreeNode root = new TreeNode(1);
        sut = new BinaryTreeTraversal();

//        List<List<Integer>> result = sut.levelOrder(root);
//        List<List<Integer>> result = sut.levelOrder2(root);
        List<List<Integer>> result = sut.levelOrder3(root);

        assertThat(result).isEqualTo(List.of(List.of(1)));
    }

    @Test
    void case3() {
        TreeNode root = null;
        sut = new BinaryTreeTraversal();

//        List<List<Integer>> result = sut.levelOrder(root);
//        List<List<Integer>> result = sut.levelOrder2(root);
        List<List<Integer>> result = sut.levelOrder3(root);

        assertThat(result).isEqualTo(List.of());
    }
}
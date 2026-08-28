package ddongman.algorithms.leet.graph;

import static org.assertj.core.api.Assertions.assertThat;

import ddongman.algorithms.leet.graph.domain.Node;
import org.junit.jupiter.api.Test;

class GraphCloneTest {

    private GraphClone sut;

    @Test
    void case1() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        sut = new GraphClone();

//        Node result = sut.cloneGraph(node1);
        Node result = sut.cloneGraph2(node1);

        assertThat(result).isNotSameAs(node1);
    }
}
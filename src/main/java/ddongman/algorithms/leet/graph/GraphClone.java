package ddongman.algorithms.leet.graph;

import ddongman.algorithms.leet.graph.domain.Node;
import java.util.HashMap;
import java.util.Map;

public class GraphClone {

    private final Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {

        if (node == null) {
            return null;
        }

        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }


        Node clonedNode = new Node(node.val);
        visited.put(node.val, clonedNode);

        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;
    }

    private final Map<Node, Node> connectMap = new HashMap<>();

    public Node cloneGraph2(Node node) {

        if (node == null) {
            return null;
        }

        if (connectMap.containsKey(node)) {
            return connectMap.get(node);
        }

        Node clonedNode = new Node(node.val);
        connectMap.put(node, clonedNode);

        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph2(neighbor));
        }

        return clonedNode;
    }
}

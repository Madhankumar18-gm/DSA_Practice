package Day14_GraphAndGreedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Problem 121: [LeetCode 133] Clone Graph
 * O(V + E) BFS and DFS Graph Deep Copying via Hash Mapping.
 */
public class CloneGraph {
    public static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public static Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        visited.put(node, new Node(node.val));
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                visited.get(curr).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
    public static Node cloneGraphDFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        return dfsClone(node, visited);
    }
    private static Node dfsClone(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) return visited.get(node);
        Node copy = new Node(node.val);
        visited.put(node, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfsClone(neighbor, visited));
        }
        return copy;
    }
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n1);
        Node cloned = cloneGraphBFS(n1);
        assert cloned != n1 && cloned.val == 1;
        assert cloned.neighbors.get(0).val == 2;
        Node clonedDFS = cloneGraphDFS(n1);
        assert clonedDFS != n1 && clonedDFS.val == 1;
        assert clonedDFS.neighbors.get(0).val == 2;
        Node single = new Node(100);
        assert cloneGraphDFS(single).val == 100;
        assert cloneGraphDFS(null) == null;
        assert cloneGraphBFS(null) == null;
        System.out.println("Execution completed successfully for CloneGraph.");
    }
}

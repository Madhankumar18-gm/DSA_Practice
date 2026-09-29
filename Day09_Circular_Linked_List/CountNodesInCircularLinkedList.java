package Day09_Circular_Linked_List;

import java.util.HashSet;
import java.util.Set;

public class CountNodesInCircularLinkedList {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static int countNodesNaive(Node head) {
        if (head == null) return 0;
        Set<Node> visited = new HashSet<>();
        Node curr = head;
        while (curr != null && !visited.contains(curr)) {
            visited.add(curr);
            curr = curr.next;
        }
        return visited.size();
    }
}

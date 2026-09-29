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

    public static int countNodesOptimal(Node head) {
        if (head == null) return 0;
        int count = 0;
        Node curr = head;
        do {
            count++;
            curr = curr.next;
        } while (curr != head);
        return count;
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        n1.next = n2; n2.next = n1;
        assert countNodesNaive(n1) == 2;
        assert countNodesOptimal(n1) == 2;
    }
}

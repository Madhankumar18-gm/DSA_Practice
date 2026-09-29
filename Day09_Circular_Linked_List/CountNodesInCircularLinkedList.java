package Day09_Circular_Linked_List;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem 80: Count Nodes in a Circular Linked List
 * Counts total nodes in a circular linked list using O(N) do-while pointer traversal and O(1) auxiliary space.
 */
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

        assert countNodesOptimal(null) == 0;
        Node s = new Node(1);
        s.next = s;
        assert countNodesOptimal(s) == 1;

        Node a = new Node(1), b = new Node(2), c = new Node(3), d = new Node(4);
        a.next = b; b.next = c; c.next = d; d.next = a;
        assert countNodesOptimal(a) == 4;
    }
}

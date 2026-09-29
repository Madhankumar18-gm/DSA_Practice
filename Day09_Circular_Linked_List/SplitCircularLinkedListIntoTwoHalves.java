import java.util.ArrayList;
import java.util.List;

/**
 * GFG / LeetCode - Split a Circular Linked List into Two Halves
 * Topic: Fast and Slow Pointer Mid-Split
 */
public class SplitCircularLinkedListIntoTwoHalves {

    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Splits a circular linked list into two balanced circular linked lists.
     * Time Complexity: O(N) where N is the number of nodes.
     * Space Complexity: O(1) auxiliary space.
     */
    public static Node[] splitList(Node head) {
        if (head == null) {
            return new Node[]{null, null};
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next.next == head) {
            fast = fast.next;
        }

        Node head1 = head;
        Node head2 = slow.next;

        fast.next = slow.next;
        slow.next = head1;

        return new Node[]{head1, head2};
    }

    public static List<Integer> toList(Node head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) return res;
        Node curr = head;
        do {
            res.add(curr.data);
            curr = curr.next;
        } while (curr != head);
        return res;
    }
}

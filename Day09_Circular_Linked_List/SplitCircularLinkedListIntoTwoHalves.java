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

        // Fast and slow pointers to locate mid-point
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

    public static void main(String[] args) {
        System.out.println("=== Testing Split Circular Linked List into Two Halves ===");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n1;

        Node[] halves = splitList(n1);
        System.out.println("Half 1: " + toList(halves[0]));
        System.out.println("Half 2: " + toList(halves[1]));
        assert toList(halves[0]).toString().equals("[1, 2]") : "Even half 1 failed!";
        assert toList(halves[1]).toString().equals("[3, 4]") : "Even half 2 failed!";

        Node o1 = new Node(1); Node o2 = new Node(2); Node o3 = new Node(3);
        o1.next = o2; o2.next = o3; o3.next = o1;
        Node[] oddHalves = splitList(o1);
        assert toList(oddHalves[0]).toString().equals("[1, 2]") : "Odd half 1 failed!";
        assert toList(oddHalves[1]).toString().equals("[3]") : "Odd half 2 failed!";
        System.out.println("Execution completed successfully for Split Circular Linked List into Two Halves.");
    }
}

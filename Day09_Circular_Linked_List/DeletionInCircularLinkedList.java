import java.util.ArrayList;
import java.util.List;

/**
 * GFG / LeetCode - Deletion in a Circular Linked List
 * Topic: Circular Linked List Pointer Unlinking
 */
public class DeletionInCircularLinkedList {

    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Deletes a given target node from a circular linked list.
     * Time Complexity: O(N) where N is number of nodes.
     * Space Complexity: O(1) auxiliary memory.
     */
    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;

        Node curr = head;
        Node prev = null;

        // Special handling if head node is to be deleted
        if (head.data == key) {
            if (head.next == head) {
                return null; // Single node list
            }
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = head.next;
            head = head.next;
            return head;
        }

        prev = head;
        curr = head.next;

        while (curr != head) {
            if (curr.data == key) {
                prev.next = curr.next;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
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
        System.out.println("=== Testing Deletion in Circular Linked List ===");
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        n1.next = n2; n2.next = n3; n3.next = n1;

        Node head = deleteNode(n1, 20);
        System.out.println("After deleting 20: " + toList(head));
        assert toList(head).toString().equals("[10, 30]") : "Middle delete failed!";

        head = deleteNode(head, 10);
        assert toList(head).toString().equals("[30]") : "Head delete failed!";

        head = deleteNode(head, 30);
        assert head == null : "Single node delete failed!";
    }
}

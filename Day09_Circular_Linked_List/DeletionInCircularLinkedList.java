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
}

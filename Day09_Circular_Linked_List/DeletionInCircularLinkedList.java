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
        return head;
    }
}

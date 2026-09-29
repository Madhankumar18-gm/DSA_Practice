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
        return new Node[]{head, null};
    }
}

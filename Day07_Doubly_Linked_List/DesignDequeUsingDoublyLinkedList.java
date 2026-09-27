/**
 * Problem 59: Design Circular Deque / Doubly Linked List Deque (LeetCode 641)
 * 
 * Design your implementation of a double-ended queue (deque) using a Doubly Linked List with sentinel nodes.
 * 
 * Time Complexity: O(1) for all insert, delete, get, and status checks.
 * Space Complexity: O(capacity) auxiliary space.
 */
public class DesignDequeUsingDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}

/**
 * Problem 59: Design Circular Deque / Doubly Linked List Deque (LeetCode 641)
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

    private final int capacity;
    private int size;
    private final Node head;
    private final Node tail;

    public DesignDequeUsingDoublyLinkedList(int k) {
        this.capacity = k;
        this.size = 0;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }
}

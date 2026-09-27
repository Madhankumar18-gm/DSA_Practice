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

    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node toDelete = head.next;
        head.next = toDelete.next;
        toDelete.next.prev = head;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        Node toDelete = tail.prev;
        tail.prev = toDelete.prev;
        toDelete.prev.next = tail;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }

    public int getRear() {
        return isEmpty() ? -1 : tail.prev.val;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }
}

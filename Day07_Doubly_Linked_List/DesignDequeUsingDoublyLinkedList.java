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

    private void addNode(Node prevNode, Node newNode, Node nextNode) {
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;
    }

    private void removeNode(Node target) {
        target.prev.next = target.next;
        target.next.prev = target.prev;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        addNode(head, new Node(value), head.next);
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        addNode(tail.prev, new Node(value), tail);
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        removeNode(head.next);
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        removeNode(tail.prev);
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

    public static void main(String[] args) {
        System.out.println("=== DesignDequeUsingDoublyLinkedList Execution Suite ===");

        DesignDequeUsingDoublyLinkedList deque = new DesignDequeUsingDoublyLinkedList(3);
        assert deque.insertLast(1) == true : "Test 1 Failed!";
        assert deque.insertLast(2) == true : "Test 2 Failed!";
        assert deque.insertFront(3) == true : "Test 3 Failed!";
        assert deque.insertFront(4) == false : "Test 4 Failed (isFull)!";

        System.out.println("Front: " + deque.getFront() + ", Rear: " + deque.getRear());
        assert deque.getFront() == 3 && deque.getRear() == 2 : "Test 5 Failed!";

        assert deque.deleteLast() == true : "Test 6 Failed!";
        assert deque.getRear() == 1 : "Test 7 Failed!";
    }
}

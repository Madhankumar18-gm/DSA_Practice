import java.util.HashMap;
import java.util.Map;

/**
 * Problem 54: LRU Cache (LeetCode 146)
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Time Complexity: O(1) for both get and put operations.
 * Space Complexity: O(capacity) for HashMap and Doubly Linked List storage.
 */
public class LRUCache {
    public static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
}

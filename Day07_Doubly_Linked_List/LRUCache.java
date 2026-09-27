import java.util.HashMap;
import java.util.Map;

/**
 * Problem 54: LRU Cache (LeetCode 146)
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Operations:
 * - get(key): Return value of key if present, else -1. Move node to head of DLL.
 * - put(key, value): Update or insert key-value pair. If capacity exceeded, evict LRU node (from tail of DLL).
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
}

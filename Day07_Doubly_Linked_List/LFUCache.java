import java.util.HashMap;
import java.util.Map;

/**
 * Problem 55: LFU Cache (LeetCode 460)
 * 
 * Design a data structure that follows the constraints of a Least Frequently Used (LFU) cache.
 * When the cache reaches capacity, evict the least frequently used key.
 * If there is a tie, evict the least recently used key among them.
 * 
 * Time Complexity: O(1) for get and put operations.
 * Space Complexity: O(capacity) using HashMap & frequency buckets of Doubly Linked Lists.
 */
public class LFUCache {
    public static class Node {
        int key, val, freq;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 55: LFU Cache (LeetCode 460)
 * 
 * Design a data structure that follows the constraints of a Least Frequently Used (LFU) cache.
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

    public static class DoublyLinkedList {
        Node head, tail;
        int size;
        DoublyLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeTail() {
            if (size == 0) return null;
            Node lru = tail.prev;
            removeNode(lru);
            return lru;
        }
    }
}

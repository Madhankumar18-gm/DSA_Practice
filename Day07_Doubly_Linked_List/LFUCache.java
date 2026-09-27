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

    private final int capacity;
    private int minFreq;
    private final Map<Integer, Node> keyMap;
    private final Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    private void updateNode(Node node) {
        int curFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(curFreq);
        oldList.removeNode(node);

        if (curFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }

    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.val = value;
            updateNode(node);
        } else {
            if (keyMap.size() == capacity) {
                DoublyLinkedList minFreqList = freqMap.get(minFreq);
                Node evictNode = minFreqList.removeTail();
                if (evictNode != null) {
                    keyMap.remove(evictNode.key);
                }
            }
            Node newNode = new Node(key, value);
            keyMap.put(key, newNode);
            minFreq = 1;
            freqMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== LFUCache Execution Suite ===");

        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);
        lfu.put(2, 2);
        int g1 = lfu.get(1); // freq of 1 becomes 2
        System.out.println("get(1): " + g1);
        assert g1 == 1 : "Test 1 Failed!";

        lfu.put(3, 3); // evicts key 2 (freq 1 vs freq 2 of key 1)
        int g2 = lfu.get(2);
        System.out.println("get(2) [evicted]: " + g2);
        assert g2 == -1 : "Test 2 Failed!";

        int g3 = lfu.get(3); // returns 3
        System.out.println("get(3): " + g3);
        assert g3 == 3 : "Test 3 Failed!";
    }
}

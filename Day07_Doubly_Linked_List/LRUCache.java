import java.util.HashMap;
import java.util.Map;

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

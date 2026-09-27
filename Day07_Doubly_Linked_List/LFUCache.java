import java.util.HashMap;
import java.util.Map;

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

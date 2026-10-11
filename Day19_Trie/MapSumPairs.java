package Day19_Trie;

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int val = 0;
    }

    private final TrieNode root;
    private final Map<String, Integer> map;

    public MapSumPairs() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (key == null) return;
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);

        TrieNode curr = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
            curr.val += delta;
        }
    }

    public int sum(String prefix) {
        if (prefix == null) return 0;
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return 0;
            curr = curr.children[idx];
        }
        return curr.val;
    }

    public static void main(String[] args) {
        MapSumPairs ms = new MapSumPairs();
        ms.insert("apple", 3);
        assert ms.sum("ap") == 3 : "Test 1 Failed";
        ms.insert("app", 2);
        assert ms.sum("ap") == 5 : "Test 2 Failed";
    }
}

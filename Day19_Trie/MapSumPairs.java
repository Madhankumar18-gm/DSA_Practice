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
}

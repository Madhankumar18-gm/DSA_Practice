package Day19_Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 677: Map Sum Pairs
 * 
 * Problem:
 * Design a map that allows you to do the following:
 * - Maps a string key to a given value.
 * - Sets the sum of all values for keys that have the prefix prefix.
 * Implement the MapSum class:
 * - MapSum() Initializes the MapSum object.
 * - void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
 * - int sum(String prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 * 
 * Complexity:
 * - Insert: O(K) time where K is key length, O(K * 26) space.
 * - Sum: O(P) time where P is prefix length, O(1) space.
 */
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

        ms.insert("apple", 5);
        assert ms.sum("ap") == 7 : "Overwrite delta sum";
        assert ms.sum("apple") == 5 : "Exact match sum";

        assert ms.sum("banana") == 0 : "Non-existent prefix";
        assert ms.sum(null) == 0 : "Null prefix query";
        ms.insert(null, 10);
    }
}

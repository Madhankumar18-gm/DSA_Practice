package Day19_Trie;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String word = null;
    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode curr = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = w;
        }
        return root;
    }

    public static void main(String[] args) {
        TrieNode root = buildTrie(new String[]{"oath", "pea", "eat", "rain"});
        assert root.children['o' - 'a'] != null : "Trie child 'o'";
        assert root.children['p' - 'a'] != null : "Trie child 'p'";
    }
}

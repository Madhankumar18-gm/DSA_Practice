package Day19_Trie;

public class ImplementTriePrefixTree {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) return;
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String word) {
        if (word == null) return false;
        TrieNode node = findNode(word);
        return node != null && node.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null) return false;
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String str) {
        TrieNode curr = root;
        for (char c : str.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) return null;
            curr = curr.children[idx];
        }
        return curr;
    }

    public static void main(String[] args) {
        ImplementTriePrefixTree trie = new ImplementTriePrefixTree();
        trie.insert("apple");
        assert trie.search("apple") : "Search apple failed";
        assert !trie.search("app") : "Search app should be false";
        assert trie.startsWith("app") : "StartsWith app should be true";
        trie.insert("app");
        assert trie.search("app") : "Search app after insert failed";

        trie.insert("banana");
        trie.insert("band");
        trie.insert("bandage");
        assert trie.startsWith("ban") : "Prefix ban";
        assert trie.search("band") : "Search band";
        assert !trie.search("ba") : "Search ba";

        assert !trie.search("xyz") : "Non-existent word";
        assert !trie.startsWith("xyz") : "Non-existent prefix";
        assert !trie.search(null) : "Null word search";
        assert !trie.startsWith(null) : "Null prefix startsWith";
    }
}

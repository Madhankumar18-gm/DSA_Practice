package Day19_Trie;

public class DesignAddAndSearchWordsDataStructure {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndOfWord = false;
    }

    private final TrieNode root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchInNode(word, 0, root);
    }

    private boolean searchInNode(String word, int index, TrieNode curr) {
        if (curr == null) return false;
        if (index == word.length()) return curr.isEndOfWord;

        char c = word.charAt(index);
        if (c == '.') {
            for (TrieNode child : curr.children) {
                if (child != null && searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            return searchInNode(word, index + 1, curr.children[idx]);
        }
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure dict = new DesignAddAndSearchWordsDataStructure();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");

        assert !dict.search("pad") : "pad should not exist";
        assert dict.search("bad") : "bad should exist";
        assert dict.search(".ad") : ".ad should match bad/dad/mad";
        assert dict.search("b..") : "b.. should match bad";

        dict.addWord("a");
        dict.addWord("ab");
        assert dict.search("a") : "Single char search";
        assert dict.search("a.") : "Single wildcard match";
        assert dict.search(".b") : "Leading wildcard match";
        assert dict.search("..") : "Double wildcard match";
    }
}

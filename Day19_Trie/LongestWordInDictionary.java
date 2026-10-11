package Day19_Trie;

/**
 * LeetCode 720: Longest Word in Dictionary
 * 
 * Problem:
 * Given an array of strings words representing an English Dictionary, return the longest word in words that can be
 * built one character at a time by other words in words.
 * If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * 
 * Complexity:
 * - Trie Insertion: O(sum of word lengths), O(sum of word lengths * 26) space.
 * - DFS Traversal: O(sum of word lengths) time to traverse connected valid prefix paths.
 */
public class LongestWordInDictionary {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String word = null;
    }

    public static String longestWord(String[] words) {
        if (words == null || words.length == 0) return "";

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

        String[] longest = new String[]{""};
        dfs(root, longest);
        return longest[0];
    }

    private static void dfs(TrieNode node, String[] longest) {
        for (TrieNode child : node.children) {
            if (child != null && child.word != null) {
                if (child.word.length() > longest[0].length() || 
                    (child.word.length() == longest[0].length() && child.word.compareTo(longest[0]) < 0)) {
                    longest[0] = child.word;
                }
                dfs(child, longest);
            }
        }
    }

    public static void main(String[] args) {
        String[] w1 = {"w", "wo", "wor", "worl", "world"};
        assert "world".equals(longestWord(w1)) : "Test 1 Failed";

        String[] w2 = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        assert "apple".equals(longestWord(w2)) : "Test 2 Failed (tie break apple vs apply)";

        String[] broken = {"m", "mo", "mop", "mops", "mopsk", "xyz"};
        assert "mopsk".equals(longestWord(broken)) : "Broken prefix chain filter";

        assert "b".equals(longestWord(new String[]{"b", "c", "d"})) : "Single letters tie break";
        assert "".equals(longestWord(new String[]{})) : "Empty array";
        assert "".equals(longestWord(null)) : "Null array";

        System.out.println("Execution completed successfully for LongestWordInDictionary.");
    }
}

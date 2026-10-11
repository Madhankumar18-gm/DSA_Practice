package Day19_Trie;

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

        // Boundary tests
        assert "b".equals(longestWord(new String[]{"b", "c", "d"})) : "Single letters tie break";
        assert "".equals(longestWord(new String[]{})) : "Empty array";
        assert "".equals(longestWord(null)) : "Null array";
    }
}

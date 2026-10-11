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
                if (child.word.length() > longest[0].length()) {
                    longest[0] = child.word;
                }
                dfs(child, longest);
            }
        }
    }
}

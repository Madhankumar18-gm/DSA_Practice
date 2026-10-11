package Day19_Trie;

import java.util.Arrays;
import java.util.List;

public class ReplaceWords {

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String rootWord = null;
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        if (dictionary == null || sentence == null) return sentence;

        TrieNode root = new TrieNode();
        for (String d : dictionary) {
            TrieNode curr = root;
            for (char c : d.toCharArray()) {
                int idx = c - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.rootWord = d;
        }

        StringBuilder sb = new StringBuilder();
        String[] tokens = sentence.split(" ");
        for (int i = 0; i < tokens.length; i++) {
            if (i > 0) sb.append(" ");
            sb.append(findRoot(root, tokens[i]));
        }

        return sb.toString();
    }

    private static String findRoot(TrieNode root, String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (curr.children[idx] == null) break;
            curr = curr.children[idx];
            if (curr.rootWord != null) {
                return curr.rootWord;
            }
        }
        return word;
    }
}

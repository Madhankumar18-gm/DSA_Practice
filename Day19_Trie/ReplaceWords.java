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

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String s = "the cattle was rattled by the battery";
        String res = replaceWords(dict, s);
        assert "the cat was rat by the bat".equals(res) : "Test 1 Failed: " + res;

        List<String> dict2 = Arrays.asList("a", "b", "c");
        String s2 = "aadsfasf absbs bbab cadsfafs";
        assert "a a b c".equals(replaceWords(dict2, s2)) : "Test 2 Failed";

        // Overlapping roots ("c", "ca", "cat") -> should pick shortest "c"
        List<String> overlap = Arrays.asList("c", "ca", "cat");
        assert "c".equals(replaceWords(overlap, "cattle")) : "Shortest root priority";
    }
}

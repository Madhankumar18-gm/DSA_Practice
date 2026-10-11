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

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return result;
        }

        TrieNode root = buildTrie(words);
        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private static void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
        char ch = board[r][c];
        if (ch == '#' || node.children[ch - 'a'] == null) return;

        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';
        dfs(board, r + 1, c, node, result);
        dfs(board, r - 1, c, node, result);
        dfs(board, r, c + 1, node, result);
        dfs(board, r, c - 1, node, result);
        board[r][c] = ch;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> res = findWords(board, words);
        assert res.contains("oath") : "Result contains oath";
        assert res.contains("eat") : "Result contains eat";
        assert !res.contains("rain") : "Result should not contain rain";

        char[][] b2 = {{'a', 'b'}, {'c', 'd'}};
        List<String> res2 = findWords(b2, new String[]{"abcb"});
        assert res2.isEmpty() : "Cannot reuse cell in same path";

        // Boundary tests
        char[][] single = {{'a'}};
        assert findWords(single, new String[]{"a"}).contains("a") : "Single cell match";
        assert findWords(null, words).isEmpty() : "Null board";
        assert findWords(board, null).isEmpty() : "Null words";
    }
}

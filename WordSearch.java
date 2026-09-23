/**
 * Problem 24: Word Search
 * 
 * Given an m x n grid of characters `board` and a string `word`, return true if word exists in the grid.
 * 
 * Time Complexity: O(N * M * 3^L) where L is word length.
 * Space Complexity: O(L) recursion stack depth.
 */
public class WordSearch {

    /**
     * Checks if word exists in grid using 4-directional DFS backtracking.
     * Time: O(N * M * 3^L), Space: O(L)
     */
    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B'}, {'C','D'}};
        System.out.println("Exists: " + exist(board, "AB"));
    }
}

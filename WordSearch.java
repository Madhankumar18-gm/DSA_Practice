/**
 * Problem 24: Word Search
 * 
 * Given an m x n grid of characters `board` and a string `word`, return true if word exists in the grid.
 */
public class WordSearch {

    // Optimal 4-directional DFS Backtracking with cell marking
    private static boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#'; // mark visited

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp; // backtrack unmark
        return found;
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null) return false;
        int rows = board.length, cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B'}, {'C','D'}};
        System.out.println("Word Search Exists: " + exist(board, "AB"));
    }
}

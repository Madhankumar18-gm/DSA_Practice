/**
 * Problem 24: Word Search
 * 
 * Given an m x n grid of characters `board` and a string `word`, return true if word exists in the grid.
 */
public class WordSearch {

    public static boolean dfsBasic(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) return true;
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        return false;
    }
}

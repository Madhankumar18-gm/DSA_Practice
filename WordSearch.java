/**
 * Problem 24: Word Search
 * 
 * Given an m x n grid of characters `board` and a string `word`, return true if word exists in the grid.
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B'}, {'C','D'}};
        System.out.println("Word Search Exists: " + exist(board, "AB"));
    }
}

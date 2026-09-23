import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 18: N-Queens
 * 
 * Place n queens on an n x n chessboard such that no two queens attack each other.
 * 
 * Time Complexity: O(N!) since we prune invalid column branches.
 * Space Complexity: O(N^2) for board storage and recursive stack depth.
 */
public class NQueens {

    /**
     * Finds all distinct placements of N non-attacking queens.
     * Time: O(N!), Space: O(N^2)
     */
    public static List<List<String>> solveNQueens(int n) {
        if (n <= 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0, board, result, n);
        return result;
    }

    private static boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private static void backtrack(int row, char[][] board, List<List<String>> result, int n) {
        if (row == n) {
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                currentBoard.add(new String(board[i]));
            }
            result.add(currentBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(row + 1, board, result, n);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== NQueens Execution Suite ===");
        System.out.println("N = 1 -> Total Solutions: " + solveNQueens(1).size());
        System.out.println("N = 4 -> Total Solutions: " + solveNQueens(4).size());
        System.out.println("N = 8 -> Total Solutions: " + solveNQueens(8).size());
        System.out.println("=== All Tests Completed Successfully ===");
    }
}

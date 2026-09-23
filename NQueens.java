import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 18: N-Queens
 * 
 * Place n queens on an n x n chessboard such that no two queens attack each other.
 */
public class NQueens {

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

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) return result;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0, board, result, n);
        return result;
    }

    public static void printSolutions(List<List<String>> solutions) {
        for (int k = 0; k < solutions.size(); k++) {
            System.out.println("Solution " + (k + 1) + ":");
            for (String row : solutions.get(k)) {
                System.out.println("  " + row);
            }
        }
    }

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        printSolutions(res);
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 18: N-Queens
 * 
 * Place n queens on an n x n chessboard such that no two queens attack each other.
 */
public class NQueens {

    public static char[][] createBoard(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        return board;
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = createBoard(n);
        return result;
    }

    public static void main(String[] args) {
        System.out.println("N=4 Solutions: " + solveNQueens(4).size());
    }
}

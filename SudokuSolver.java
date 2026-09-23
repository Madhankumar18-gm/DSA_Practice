/**
 * Problem 19: Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells in-place.
 * 
 * Time Complexity: O(9^(9x9)) worst case, heavily reduced by pruning valid constraint options.
 * Space Complexity: O(81) = O(1) recursion call stack depth for 9x9 grid.
 */
public class SudokuSolver {

    /**
     * Solves a Sudoku puzzle in-place using backtracking.
     * Time: O(9^(81)), Space: O(1)
     */
    public static void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        solve(board);
    }

    private static boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, r, c, ch)) {
                            board[r][c] = ch;
                            if (solve(board)) return true;
                            board[r][c] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Sudoku Solver Ready.");
    }
}

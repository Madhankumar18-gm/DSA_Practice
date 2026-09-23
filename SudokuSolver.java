/**
 * Problem 19: Sudoku Solver
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells in-place.
 */
public class SudokuSolver {

    public static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false;
        }
        return true;
    }

    public static boolean solve(char[][] board) {
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

    public static void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        solve(board);
    }

    public static void main(String[] args) {
        solveSudoku(null);
        solveSudoku(new char[0][0]);
        System.out.println("Null & Invalid board guards passed.");
    }
}

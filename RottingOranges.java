import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 14: Rotting Oranges
 * 
 * Minimum minutes until no cell has a fresh orange using multi-source BFS Queue.
 */
public class RottingOranges {

    public static int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        return freshCount == 0 ? 0 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 2}};
        System.out.println("Result: " + orangesRotting(grid));
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 14: Rotting Oranges
 * 
 * Minimum minutes until no cell has a fresh orange using multi-source BFS Queue.
 * 
 * Time Complexity: O(R * C) visiting each grid cell at most once.
 * Space Complexity: O(R * C) queue storing positions.
 */
public class RottingOranges {

    /**
     * Calculates rotting time using Multi-Source BFS Queue.
     * Time: O(R * C), Space: O(R * C)
     */
    public static int orangesRottingBFS(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.add(new int[]{r, c});
                else if (grid[r][c] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && freshCount > 0) {
            minutes++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : dirs) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshCount--;
                        queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static int orangesRotting(int[][] grid) {
        return orangesRottingBFS(grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println("Minutes: " + orangesRotting(grid));
    }
}

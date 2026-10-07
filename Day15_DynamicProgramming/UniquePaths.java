package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 62: Unique Paths
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class UniquePaths {

    public static int uniquePaths2D(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static int uniquePathsOptimal(int m, int n) {
        if (m <= 0 || n <= 0) return 0;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        assert uniquePaths2D(3, 7) == 28 : "Test 1 Failed: 2D 3x7";
        assert uniquePaths2D(3, 2) == 3 : "Test 2 Failed: 2D 3x2";

        assert uniquePathsOptimal(3, 7) == 28 : "Test 3 Failed: Optimal 3x7";
        assert uniquePathsOptimal(3, 2) == 3 : "Test 4 Failed: Optimal 3x2";
    }
}

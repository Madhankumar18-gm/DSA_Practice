package Day15_DynamicProgramming;

/**
 * LeetCode 72: Edit Distance
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class EditDistance {

    public static int minDistance2D(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[m][n];
    }

    public static int minDistanceOptimal(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for (int j = 0; j <= n; j++) dp[j] = j;
        for (int i = 1; i <= m; i++) {
            int prevDiagonal = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = prevDiagonal;
                } else {
                    dp[j] = 1 + Math.min(prevDiagonal, Math.min(dp[j], dp[j - 1]));
                }
                prevDiagonal = temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        assert minDistance2D("horse", "ros") == 3 : "Test 1 Failed: 2D horse/ros";
        assert minDistance2D("intention", "execution") == 5 : "Test 2 Failed: 2D intention/execution";

        assert minDistanceOptimal("horse", "ros") == 3 : "Test 3 Failed: Optimal horse/ros";
        assert minDistanceOptimal("intention", "execution") == 5 : "Test 4 Failed: Optimal intention/execution";

        assert minDistanceOptimal("zoologicoarchaeologist", "zoogeologist") == 10 : "Refactor Test: Complex Edit";
    }
}

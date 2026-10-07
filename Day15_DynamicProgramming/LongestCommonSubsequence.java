package Day15_DynamicProgramming;

/**
 * LeetCode 1143: Longest Common Subsequence
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence2D(String text1, String text2) {
        if (text1 == null || text2 == null) return 0;
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        assert longestCommonSubsequence2D("abcde", "ace") == 3 : "Test 1 Failed: 2D abcde/ace";
        assert longestCommonSubsequence2D("abc", "abc") == 3 : "Test 2 Failed: 2D abc/abc";
        assert longestCommonSubsequence2D("abc", "def") == 0 : "Test 3 Failed: 2D abc/def";
    }
}

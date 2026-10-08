package Day16_DPKnapsack;

/**
 * LeetCode 474: Ones and Zeroes (2D Capacity 0/1 Knapsack)
 * Day 16 - Dynamic Programming (Knapsack Variants)
 */
public class OnesAndZeros {

    public static int findMaxFormMemo(String[] strs, int m, int n) {
        if (strs == null || m < 0 || n < 0) return 0;
        Integer[][][] memo = new Integer[strs.length + 1][m + 1][n + 1];
        return helper(strs, 0, m, n, memo);
    }

    private static int helper(String[] strs, int idx, int zeros, int ones, Integer[][][] memo) {
        if (idx == strs.length) return 0;
        if (memo[idx][zeros][ones] != null) return memo[idx][zeros][ones];
        int[] count = countZerosOnes(strs[idx]);
        int z = count[0], o = count[1];
        int include = 0;
        if (zeros >= z && ones >= o) {
            include = 1 + helper(strs, idx + 1, zeros - z, ones - o, memo);
        }
        int exclude = helper(strs, idx + 1, zeros, ones, memo);
        memo[idx][zeros][ones] = Math.max(include, exclude);
        return memo[idx][zeros][ones];
    }

    private static int[] countZerosOnes(String s) {
        int z = 0, o = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') z++;
            else if (c == '1') o++;
        }
        return new int[]{z, o};
    }

    public static int findMaxFormOptimal(String[] strs, int m, int n) {
        if (strs == null || m < 0 || n < 0) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int[] count = countZerosOnes(str);
            int zeros = count[0], ones = count[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        assert findMaxFormMemo(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3) == 4 : "Test 1 Failed: Memo m=5, n=3";
        assert findMaxFormMemo(new String[]{"10", "0", "1"}, 1, 1) == 2 : "Test 2 Failed: Memo m=1, n=1";

        assert findMaxFormOptimal(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3) == 4 : "Test 3 Failed: Optimal m=5, n=3";
        assert findMaxFormOptimal(new String[]{"10", "0", "1"}, 1, 1) == 2 : "Test 4 Failed: Optimal m=1, n=1";
    }
}

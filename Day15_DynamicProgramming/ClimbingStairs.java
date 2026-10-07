package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 70: Climbing Stairs
 * Day 15 - Dynamic Programming (1D & 2D)
 */
public class ClimbingStairs {

    public static int climbStairsMemo(int n) {
        if (n <= 0) return 0;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbHelper(n, memo);
    }

    private static int climbHelper(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = climbHelper(n - 1, memo) + climbHelper(n - 2, memo);
        return memo[n];
    }
}

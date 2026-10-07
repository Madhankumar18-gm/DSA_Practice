package Day15_DynamicProgramming;

import java.util.Arrays;

/**
 * LeetCode 70: Climbing Stairs
 * Day 15 - Dynamic Programming (1D & 2D)
 *
 * Problem Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Complexities:
 * Top-Down Memoization: Time O(N), Space O(N)
 * Bottom-Up Space-Optimized DP: Time O(N), Space O(1)
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

    public static int climbStairsOptimal(int n) {
        if (n <= 2) return Math.max(0, n);
        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        assert climbStairsMemo(2) == 2 : "Test 1 Failed: Memo n=2";
        assert climbStairsMemo(3) == 3 : "Test 2 Failed: Memo n=3";
        assert climbStairsMemo(5) == 8 : "Test 3 Failed: Memo n=5";

        assert climbStairsOptimal(2) == 2 : "Test 4 Failed: Optimal n=2";
        assert climbStairsOptimal(3) == 3 : "Test 5 Failed: Optimal n=3";
        assert climbStairsOptimal(5) == 8 : "Test 6 Failed: Optimal n=5";
        assert climbStairsOptimal(10) == climbStairsMemo(10) : "Test 7 Failed: Equivalence n=10";

        assert climbStairsOptimal(1) == 1 : "Refactor Test: Single Step";
        assert climbStairsOptimal(0) == 0 : "Edge Test: 0 steps";
        assert climbStairsOptimal(-5) == 0 : "Edge Test: Negative steps";
    }
}

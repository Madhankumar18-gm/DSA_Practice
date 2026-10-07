# 📅 Daily LeetCode & Data Structures Study Log - October 07, 2026

## 🎯 Day 15 Focus: Dynamic Programming (1D & 2D) Concepts

Today's practice covers **9 comprehensive Dynamic Programming problems** in Java, spanning 1D linear recurrences, unbounded & 0/1 knapsack patterns, 2D matrix/grid pathing, longest common subsequence, edit distance, and target sum subset partitioning.

---

## 💡 Topic Overview: Dynamic Programming Mechanics

Mastering **1D & 2D Dynamic Programming** enables optimal solution formulation by identifying overlapping subproblems, defining optimal substructure, establishing base cases, and optimizing space complexity from 2D matrices down to 1D arrays or variables.

---

## 📝 Problem Summary Table (Day 15 - 9 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P129) | **[LeetCode 70] Climbing Stairs** | Easy | Top-Down Memoization & $O(1)$ Space Bottom-Up DP | [ClimbingStairs.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/ClimbingStairs.java) |
| 2 (P130) | **[LeetCode 198] House Robber** | Medium | Non-Adjacent Element Selection & $O(1)$ Space DP | [HouseRobber.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/HouseRobber.java) |
| 3 (P131) | **[LeetCode 322] Coin Change** | Medium | Unbounded Knapsack 1D Minimum Coin DP | [CoinChange.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/CoinChange.java) |
| 4 (P132) | **[LeetCode 300] Longest Increasing Subsequence** | Medium | $O(N^2)$ 1D DP & $O(N \log N)$ Binary Search Patience Sorting | [LongestIncreasingSubsequence.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/LongestIncreasingSubsequence.java) |
| 5 (P133) | **[LeetCode 416] Partition Equal Subset Sum** | Medium | 0/1 Knapsack 1D Boolean Subset Target DP | [PartitionEqualSubsetSum.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/PartitionEqualSubsetSum.java) |
| 6 (P134) | **[LeetCode 62] Unique Paths** | Medium | 2D Grid Way-Counting DP & 1D Row Space Optimization | [UniquePaths.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/UniquePaths.java) |
| 7 (P135) | **[LeetCode 1143] Longest Common Subsequence** | Medium | 2D String Alignment DP & Double-Row Space Reduction | [LongestCommonSubsequence.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/LongestCommonSubsequence.java) |
| 8 (P136) | **[LeetCode 72] Edit Distance** | Medium | 2D Matrix String Modification DP (Insert, Delete, Replace) | [EditDistance.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/EditDistance.java) |
| 9 (P137) | **[LeetCode 494] Target Sum** | Medium | HashMap Top-Down Memoization & 1D Subset Sum Transformation | [TargetSum.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-07/TargetSum.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day15_DynamicProgramming/*.java
java -ea -cp . Day15_DynamicProgramming.ClimbingStairs
java -ea -cp . Day15_DynamicProgramming.HouseRobber
java -ea -cp . Day15_DynamicProgramming.CoinChange
java -ea -cp . Day15_DynamicProgramming.LongestIncreasingSubsequence
java -ea -cp . Day15_DynamicProgramming.PartitionEqualSubsetSum
java -ea -cp . Day15_DynamicProgramming.UniquePaths
java -ea -cp . Day15_DynamicProgramming.LongestCommonSubsequence
java -ea -cp . Day15_DynamicProgramming.EditDistance
java -ea -cp . Day15_DynamicProgramming.TargetSum
```

All 9 files passed all assertion checks cleanly!

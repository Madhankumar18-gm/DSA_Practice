# 📅 Daily LeetCode & Data Structures Study Log - October 08, 2026

## 🎯 Day 16 Focus: Dynamic Programming - Knapsack Variants

Today's practice covers **9 comprehensive Knapsack Dynamic Programming problems** in Java, spanning standard 0/1 Knapsack, Subset Sum, Partition Equal Subset Sum, Minimum Subset Sum Difference, Target Sum, Unbounded Knapsack / Rod Cutting, Coin Change II combinations, Combination Sum IV permutations, and 2D Capacity Knapsack (Ones and Zeroes).

---

## 💡 Topic Overview: Knapsack DP Mechanics

Mastering **Knapsack Variants** enables optimal problem solving across items decision spaces:
1. **0/1 Knapsack Pattern**: Each item can be included at most once. Iterate capacity backward `W -> wt[i]` in 1D DP to avoid duplicate item inclusion.
2. **Unbounded Knapsack Pattern**: Each item can be reused infinitely. Iterate capacity forward `wt[i] -> W` in 1D DP to allow repeated item choices.
3. **Multi-Constraint / 2D Knapsack**: Multiple capacity constraints (e.g., zeros and ones) require multi-dimensional backward iteration in DP space.

---

## 📝 Problem Summary Table (Day 16 - 9 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P138) | **0/1 Knapsack Problem** | Medium | 0/1 Knapsack 2D Matrix & 1D Backward Capacity DP | [ZeroOneKnapsack.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/ZeroOneKnapsack.java) |
| 2 (P139) | **Subset Sum Problem** | Medium | 0/1 Knapsack Boolean Subset Target DP | [SubsetSumProblem.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/SubsetSumProblem.java) |
| 3 (P140) | **[LeetCode 416] Partition Equal Subset Sum** | Medium | 0/1 Knapsack Partition Halving DP | [PartitionEqualSubsetSum.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/PartitionEqualSubsetSum.java) |
| 4 (P141) | **Minimum Subset Sum Difference** | Medium | 0/1 Knapsack Half-Sum Reachability Optimization | [MinimumSubsetSumDifference.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/MinimumSubsetSumDifference.java) |
| 5 (P142) | **[LeetCode 494] Target Sum** | Medium | 0/1 Knapsack Algebraic Target-to-Subset Sum Shift | [TargetSumKnapsack.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/TargetSumKnapsack.java) |
| 6 (P143) | **Unbounded Knapsack / Rod Cutting** | Medium | Unbounded Knapsack 1D Forward Capacity DP | [UnboundedKnapsack.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/UnboundedKnapsack.java) |
| 7 (P144) | **[LeetCode 518] Coin Change II** | Medium | Unbounded Knapsack Combinational Coin Sum DP | [CoinChangeII.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/CoinChangeII.java) |
| 8 (P145) | **[LeetCode 377] Combination Sum IV** | Medium | Unbounded Knapsack Permutational Sequence Count DP | [CombinationSumIV.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/CombinationSumIV.java) |
| 9 (P146) | **[LeetCode 474] Ones and Zeroes** | Medium | 2D Capacity Constraint (Zeros & Ones) 0/1 Knapsack DP | [OnesAndZeros.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-08/OnesAndZeros.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day16_DPKnapsack/*.java
java -ea -cp . Day16_DPKnapsack.ZeroOneKnapsack
java -ea -cp . Day16_DPKnapsack.SubsetSumProblem
java -ea -cp . Day16_DPKnapsack.PartitionEqualSubsetSum
java -ea -cp . Day16_DPKnapsack.MinimumSubsetSumDifference
java -ea -cp . Day16_DPKnapsack.TargetSumKnapsack
java -ea -cp . Day16_DPKnapsack.UnboundedKnapsack
java -ea -cp . Day16_DPKnapsack.CoinChangeII
java -ea -cp . Day16_DPKnapsack.CombinationSumIV
java -ea -cp . Day16_DPKnapsack.OnesAndZeros
```

All 9 files passed all assertion checks cleanly!

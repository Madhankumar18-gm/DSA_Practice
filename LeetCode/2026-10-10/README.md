# 📅 Daily LeetCode & Data Structures Study Log - October 10, 2026

## 🎯 Day 18 Focus: Mock Test - Heaps & Priority Queue Assessment

Today's practice covers **7 comprehensive Mock Test Heap & Priority Queue problems** in Java, simulating interview-grade challenges under timed assessment constraints: stone weight destruction simulation, saddleback sorted matrix traversal, adjacent duplicate character separation, optimal dynamic resource allocation, k-pair combinations, subsequence score maximization, and capital maximization (IPO).

---

## 💡 Mock Test Key Patterns & Strategies

1. **Greedy Resource Selection with Min-Heap**: When choosing which jumps to assign scarce items (e.g., ladders vs. bricks in LC 1642), allocate ladders to the largest climbs by keeping a Min-Heap of size $L$. The smallest element evicted gets paid with bricks.
2. **Frequency-Constrained Rearrangement**: When placing non-adjacent characters (LC 767), always extract the most frequent character from a Max-Heap, place it, and temporarily hold it until another character has been placed.
3. **Dual-Heap Capital Strategy (IPO)**: Sort tasks by minimum eligibility requirements (capital) and incrementally add unlocked opportunities to a Max-Heap of yields (profits). This guarantees $O(N \log N)$ greedy decisions.
4. **Sorted Matrix Multi-Way Merge**: Push the first column of the matrix into a Min-Heap of size $N$ and advance row-by-row in $O(K \log N)$ to find the Kth smallest element.

---

## 📝 Problem Summary Table (Day 18 - 7 Problems)

| # | Problem Name | Difficulty | Key Concepts / Pattern | File Link |
|---|---|---|---|---|
| 1 (P154) | **[LeetCode 1046] Last Stone Weight** | Easy | Max-Heap Stone Smashing Simulation | [LastStoneWeight.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/LastStoneWeight.java) |
| 2 (P155) | **[LeetCode 378] Kth Smallest Element in a Sorted Matrix** | Medium | Min-Heap Multi-Pointer / Binary Search Range | [KthSmallestElementInSortedMatrix.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/KthSmallestElementInSortedMatrix.java) |
| 3 (P156) | **[LeetCode 767] Reorganize String** | Medium | Max-Heap Character Frequency Greedy Interleaving | [ReorganizeString.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/ReorganizeString.java) |
| 4 (P157) | **[LeetCode 1642] Furthest Building You Can Reach** | Medium | Min-Heap Greedy Ladder Allocation | [FurthestBuildingYouCanReach.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/FurthestBuildingYouCanReach.java) |
| 5 (P158) | **[LeetCode 373] Find K Pairs with Smallest Sums** | Medium | Min-Heap Pair Traversal Multi-Pointer | [FindKPairsWithSmallestSums.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/FindKPairsWithSmallestSums.java) |
| 6 (P159) | **[LeetCode 2542] Maximum Subsequence Score** | Medium | Min-Heap Size K + Multiplier Sorting | [MaximumSubsequenceScore.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/MaximumSubsequenceScore.java) |
| 7 (P160) | **[LeetCode 502] IPO** | Hard | Greedy Dual-Heap (Capital Min-Heap + Profit Max-Heap) | [IPO.java](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-10-10/IPO.java) |

---

## 🛠️ Verification & Test Suite

All solutions have been verified using inline test harnesses and Java assertions (`java -ea`):
```bash
javac Day18_MockTest_Heaps/*.java
java -ea -cp . Day18_MockTest_Heaps.LastStoneWeight
java -ea -cp . Day18_MockTest_Heaps.KthSmallestElementInSortedMatrix
java -ea -cp . Day18_MockTest_Heaps.ReorganizeString
java -ea -cp . Day18_MockTest_Heaps.FurthestBuildingYouCanReach
java -ea -cp . Day18_MockTest_Heaps.FindKPairsWithSmallestSums
java -ea -cp . Day18_MockTest_Heaps.MaximumSubsequenceScore
java -ea -cp . Day18_MockTest_Heaps.IPO
```

All 7 files passed all assertion checks cleanly!

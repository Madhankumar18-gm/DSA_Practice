# LeetCode Solutions - September 28, 2026 (Day 08: Stack & Monotonic Stack)

This directory contains standalone Java implementations for 9 LeetCode problems centered on **Stack Data Structures**, **Monotonic Stacks**, and **Expression Parsing**. Each problem includes complete source code, inline complexity analysis, helper methods, and executable main test harnesses with runtime assertions (`assert`).

---

## 📅 Daily Problem Matrix

| # | Problem Name | Difficulty | Key Pattern / Technique | Java File |
|---|---|---|---|---|
| 1 | [LeetCode 84] Largest Rectangle in Histogram | Hard | Monotonic Increasing Stack, $O(N)$ Boundary Scan | [`LargestRectangleInHistogram.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/LargestRectangleInHistogram.java) |
| 2 | [LeetCode 85] Maximal Rectangle | Hard | 2D Grid to 1D Monotonic Histogram Stack | [`MaximalRectangle.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/MaximalRectangle.java) |
| 3 | [LeetCode 42] Trapping Rain Water | Hard | Monotonic Decreasing Stack, Trap Bounded Area | [`TrappingRainWater.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/TrappingRainWater.java) |
| 4 | [LeetCode 503] Next Greater Element II | Medium | Monotonic Stack on Circular Array ($2N-1$) | [`NextGreaterElementII.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/NextGreaterElementII.java) |
| 5 | [LeetCode 901] Online Stock Span | Medium | Dynamic Monotonic Stack `(price, span)` | [`OnlineStockSpan.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/OnlineStockSpan.java) |
| 6 | [LeetCode 224] Basic Calculator | Hard | Stack State Evaluation, Signs & Parentheses | [`BasicCalculator.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/BasicCalculator.java) |
| 7 | [LeetCode 316] Remove Duplicate Letters | Medium | Monotonic Stack + Freq Count + Visited Array | [`RemoveDuplicateLetters.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/RemoveDuplicateLetters.java) |
| 8 | [LeetCode 946] Validate Stack Sequences | Medium | Stack Pointer Push/Pop Simulation | [`ValidateStackSequences.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/ValidateStackSequences.java) |
| 9 | [LeetCode 402] Remove K Digits | Medium | Monotonic Stack Greedy Digit Removal | [`RemoveKDigits.java`](file:///c:/Users/gmadh/Desktop/DSA%20Practice/LeetCode/2026-09-28/RemoveKDigits.java) |

---

## 🔑 Key Patterns & Learnings

1. **Monotonic Increasing Stack**: Used in Histogram Area and Remove K Digits to maintain elements in non-decreasing order, enabling $O(N)$ nearest smaller element queries.
2. **Monotonic Decreasing Stack**: Used in Trapping Rain Water and Next Greater Element II to efficiently bound elements by larger neighbors.
3. **Circular Array Traversal**: Traversing $2N - 1$ indices with `i % n` simulates a circular array without physically duplicating memory.
4. **State Stacking in Expression Evaluation**: Pushing running result and sign context onto the stack when encountering `(` enables proper nesting evaluation upon encountering `)`.

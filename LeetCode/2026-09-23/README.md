# 📅 Daily LeetCode Log - 2026-09-23

This directory contains the 18 LeetCode problems completed on **2026-09-23** covering Stack & Queue concepts and Advanced Backtracking techniques.

---

## 📝 Problem Summary & Complexity Breakdown

### Section 1: Stack & Queue Concepts (10 Problems)

| Problem | LeetCode Link | Topic Tag | Time Complexity | Space Complexity | Solution Code |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Min Stack** | [LeetCode #155](https://leetcode.com/problems/min-stack/) | Stack Design | $O(1)$ | $O(N)$ | [`MinStack.java`](./MinStack.java) |
| **Evaluate Reverse Polish Notation** | [LeetCode #150](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | Stack Math | $O(N)$ | $O(N)$ | [`EvaluateReversePolishNotation.java`](./EvaluateReversePolishNotation.java) |
| **Daily Temperatures** | [LeetCode #739](https://leetcode.com/problems/daily-temperatures/) | Monotonic Stack | $O(N)$ | $O(N)$ | [`DailyTemperatures.java`](./DailyTemperatures.java) |
| **Implement Queue using Stacks** | [LeetCode #232](https://leetcode.com/problems/implement-queue-using-stacks/) | DS Design | Amortized $O(1)$ | $O(N)$ | [`ImplementQueueUsingStacks.java`](./ImplementQueueUsingStacks.java) |
| **Implement Stack using Queues** | [LeetCode #225](https://leetcode.com/problems/implement-stack-using-queues/) | DS Design | $O(1)$ pop | $O(N)$ | [`ImplementStackUsingQueues.java`](./ImplementStackUsingQueues.java) |
| **Sliding Window Maximum** | [LeetCode #239](https://leetcode.com/problems/sliding-window-maximum/) | Monotonic Deque | $O(N)$ | $O(k)$ | [`SlidingWindowMaximum.java`](./SlidingWindowMaximum.java) |
| **Rotting Oranges** | [LeetCode #994](https://leetcode.com/problems/rotting-oranges/) | Queue BFS | $O(R \times C)$ | $O(R \times C)$ | [`RottingOranges.java`](./RottingOranges.java) |
| **Decode String** | [LeetCode #394](https://leetcode.com/problems/decode-string/) | Stack Recursion | $O(N)$ | $O(N)$ | [`DecodeString.java`](./DecodeString.java) |
| **Asteroid Collision** | [LeetCode #735](https://leetcode.com/problems/asteroid-collision/) | Stack Simulation | $O(N)$ | $O(N)$ | [`AsteroidCollision.java`](./AsteroidCollision.java) |
| **Simplify Path** | [LeetCode #71](https://leetcode.com/problems/simplify-path/) | Stack Parsing | $O(N)$ | $O(N)$ | [`SimplifyPath.java`](./SimplifyPath.java) |

### Section 2: Advanced Backtracking (8 Problems)

| Problem | LeetCode Link | Topic Tag | Time Complexity | Space Complexity | Solution Code |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **N-Queens** | [LeetCode #51](https://leetcode.com/problems/n-queens/) | Backtracking | $O(N!)$ | $O(N^2)$ | [`NQueens.java`](./NQueens.java) |
| **Sudoku Solver** | [LeetCode #37](https://leetcode.com/problems/sudoku-solver/) | Backtracking | $O(9^{81})$ | $O(1)$ | [`SudokuSolver.java`](./SudokuSolver.java) |
| **Permutations** | [LeetCode #46](https://leetcode.com/problems/permutations/) | Backtracking | $O(N \times N!)$ | $O(N)$ | [`Permutations.java`](./Permutations.java) |
| **Permutations II** | [LeetCode #47](https://leetcode.com/problems/permutations-ii/) | Backtracking | $O(N \times N!)$ | $O(N)$ | [`PermutationsII.java`](./PermutationsII.java) |
| **Subsets** | [LeetCode #78](https://leetcode.com/problems/subsets/) | Backtracking | $O(N \times 2^N)$ | $O(N)$ | [`Subsets.java`](./Subsets.java) |
| **Combination Sum** | [LeetCode #39](https://leetcode.com/problems/combination-sum/) | Backtracking | $O(N^{T/M})$ | $O(T/M)$ | [`CombinationSum.java`](./CombinationSum.java) |
| **Word Search** | [LeetCode #79](https://leetcode.com/problems/word-search/) | Grid DFS | $O(N \times M \times 3^L)$ | $O(L)$ | [`WordSearch.java`](./WordSearch.java) |
| **Palindrome Partitioning** | [LeetCode #131](https://leetcode.com/problems/palindrome-partitioning/) | Backtracking | $O(N \times 2^N)$ | $O(N)$ | [`PalindromePartitioning.java`](./PalindromePartitioning.java) |

---

## 💡 Key Takeaways
- **Monotonic Stack/Deque**: Maintaining non-increasing or non-decreasing elements in a stack/deque enables optimal $O(N)$ linear scans (Daily Temperatures, Sliding Window Max).
- **Multi-Source BFS**: Queue level-by-level traversal simultaneously rotting fresh oranges in optimal $O(R \times C)$ grid steps.
- **State Backtracking**: Restoring state after recursive exploration (`board[r][c] = '.'` or `visited = false`) ensures complete state-space searches (N-Queens, Sudoku, Word Search).

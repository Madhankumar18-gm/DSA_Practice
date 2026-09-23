# 🚀 DSA Practice Repository - Daily Study Log & Problem Checklist

Welcome to the **DSA Practice Repository**. This repository contains a structured collection of Data Structures and Algorithms (DSA) problems solved in Java, organized by daily study topics, date-based LeetCode folders, and mock test tracking.

---

## 📊 Repository Summary

- **Total Problems Solved**: `25 Problems`
- **Total Git Commits**: `209 Commits`
- **Primary Language**: `Java 17+`
- **Remote Repository**: [GitHub - DSA_Practice](https://github.com/Madhankumar18-gm/DSA_Practice.git)

---

## 📅 Study Progress Tracker & Checklist

- [x] **Day 01 - Core DSA Concepts** (Arrays, Linked Lists, Stacks, Trees, Sliding Window, Intervals, DP) — `7 Problems` \| `56 Commits`
- [x] **Day 02 - Stack & Queue Deep Dive** (Design, Monotonic Stack, Monotonic Deque, Multi-Source BFS) — `10 Problems` \| `80 Commits`
- [x] **Day 03 - Advanced Backtracking** (N-Queens, Sudoku Solver, Permutations, Subsets, Grid DFS) — `8 Problems` \| `72 Commits`
- [ ] **Day 04 - Graphs & Advanced Trees** (TBD)
- [ ] **Day 05 - Dynamic Programming Advanced** (TBD)

---

## 📁 Repository Directory Structure

```text
DSA Practice/
├── README.md                            # Main study log, problem checklist & commit tracker
├── .gitignore                           # Java environment gitignore rules
│
├── Day01_Core_DSA/                      # Topic Folder Day 1 (7 problems)
│   ├── TwoSum.java
│   ├── ReverseLinkedList.java
│   ├── ValidParentheses.java
│   ├── BinaryTreeInorderTraversal.java
│   ├── LongestSubstring.java
│   ├── MergeIntervals.java
│   └── CoinChange.java
│
├── Day02_Stack_and_Queue/               # Topic Folder Day 2 (10 problems)
│   ├── MinStack.java
│   ├── EvaluateReversePolishNotation.java
│   ├── DailyTemperatures.java
│   ├── ImplementQueueUsingStacks.java
│   ├── ImplementStackUsingQueues.java
│   ├── SlidingWindowMaximum.java
│   ├── RottingOranges.java
│   ├── DecodeString.java
│   ├── AsteroidCollision.java
│   └── SimplifyPath.java
│
├── Day03_Advanced_Backtracking/         # Topic Folder Day 3 (8 problems)
│   ├── NQueens.java
│   ├── SudokuSolver.java
│   ├── Permutations.java
│   ├── PermutationsII.java
│   ├── Subsets.java
│   ├── CombinationSum.java
│   ├── WordSearch.java
│   └── PalindromePartitioning.java
│
├── LeetCode/                            # Daily Date Folders for LeetCode Problems
│   ├── 2026-09-22/                      # 2026-09-22 Daily Log & 7 Problems
│   │   ├── README.md
│   │   └── ...
│   └── 2026-09-23/                      # 2026-09-23 Daily Log & 18 Problems
│       ├── README.md
│       └── ...
│
└── MockTests/                           # Practice Test Attempt Logs & Results
    └── Day01_MockTest/
        └── README.md
```

---

## 📚 Complete Problems Index & Complexity Table

### Day 01: Core DSA Concepts
| # | Problem Name | LeetCode Link | Topic Tag | Time | Space | Solution Code |
| :-: | :--- | :--- | :--- | :--- | :--- | :--- |
| 1 | Two Sum | [LeetCode #1](https://leetcode.com/problems/two-sum/) | Arrays & Hashing | $O(N)$ | $O(N)$ | [`TwoSum.java`](./Day01_Core_DSA/TwoSum.java) |
| 2 | Reverse Linked List | [LeetCode #206](https://leetcode.com/problems/reverse-linked-list/) | Linked Lists | $O(N)$ | $O(1)$ | [`ReverseLinkedList.java`](./Day01_Core_DSA/ReverseLinkedList.java) |
| 3 | Valid Parentheses | [LeetCode #20](https://leetcode.com/problems/valid-parentheses/) | Stack | $O(N)$ | $O(N)$ | [`ValidParentheses.java`](./Day01_Core_DSA/ValidParentheses.java) |
| 4 | Binary Tree Inorder Traversal | [LeetCode #94](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Trees & DFS | $O(N)$ | $O(H)$ | [`BinaryTreeInorderTraversal.java`](./Day01_Core_DSA/BinaryTreeInorderTraversal.java) |
| 5 | Longest Substring Without Repeating | [LeetCode #3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding Window | $O(N)$ | $O(\min(N, M))$ | [`LongestSubstring.java`](./Day01_Core_DSA/LongestSubstring.java) |
| 6 | Merge Intervals | [LeetCode #56](https://leetcode.com/problems/merge-intervals/) | Sorting & Intervals | $O(N \log N)$ | $O(N)$ | [`MergeIntervals.java`](./Day01_Core_DSA/MergeIntervals.java) |
| 7 | Coin Change | [LeetCode #322](https://leetcode.com/problems/coin-change/) | Dynamic Programming | $O(A \times N)$ | $O(A)$ | [`CoinChange.java`](./Day01_Core_DSA/CoinChange.java) |

### Day 02: Stack & Queue Concepts
| # | Problem Name | LeetCode Link | Topic Tag | Time | Space | Solution Code |
| :-: | :--- | :--- | :--- | :--- | :--- | :--- |
| 8 | Min Stack | [LeetCode #155](https://leetcode.com/problems/min-stack/) | Stack Design | $O(1)$ | $O(N)$ | [`MinStack.java`](./Day02_Stack_and_Queue/MinStack.java) |
| 9 | Evaluate Reverse Polish Notation | [LeetCode #150](https://leetcode.com/problems/evaluate-reverse-polish-notation/) | Stack Math | $O(N)$ | $O(N)$ | [`EvaluateReversePolishNotation.java`](./Day02_Stack_and_Queue/EvaluateReversePolishNotation.java) |
| 10 | Daily Temperatures | [LeetCode #739](https://leetcode.com/problems/daily-temperatures/) | Monotonic Stack | $O(N)$ | $O(N)$ | [`DailyTemperatures.java`](./Day02_Stack_and_Queue/DailyTemperatures.java) |
| 11 | Implement Queue using Stacks | [LeetCode #232](https://leetcode.com/problems/implement-queue-using-stacks/) | DS Design | Amortized $O(1)$ | $O(N)$ | [`ImplementQueueUsingStacks.java`](./Day02_Stack_and_Queue/ImplementQueueUsingStacks.java) |
| 12 | Implement Stack using Queues | [LeetCode #225](https://leetcode.com/problems/implement-stack-using-queues/) | DS Design | $O(1)$ pop | $O(N)$ | [`ImplementStackUsingQueues.java`](./Day02_Stack_and_Queue/ImplementStackUsingQueues.java) |
| 13 | Sliding Window Maximum | [LeetCode #239](https://leetcode.com/problems/sliding-window-maximum/) | Monotonic Deque | $O(N)$ | $O(k)$ | [`SlidingWindowMaximum.java`](./Day02_Stack_and_Queue/SlidingWindowMaximum.java) |
| 14 | Rotting Oranges | [LeetCode #994](https://leetcode.com/problems/rotting-oranges/) | Queue BFS | $O(R \times C)$ | $O(R \times C)$ | [`RottingOranges.java`](./Day02_Stack_and_Queue/RottingOranges.java) |
| 15 | Decode String | [LeetCode #394](https://leetcode.com/problems/decode-string/) | Stack Recursion | $O(N)$ | $O(N)$ | [`DecodeString.java`](./Day02_Stack_and_Queue/DecodeString.java) |
| 16 | Asteroid Collision | [LeetCode #735](https://leetcode.com/problems/asteroid-collision/) | Stack Simulation | $O(N)$ | $O(N)$ | [`AsteroidCollision.java`](./Day02_Stack_and_Queue/AsteroidCollision.java) |
| 17 | Simplify Path | [LeetCode #71](https://leetcode.com/problems/simplify-path/) | Stack Parsing | $O(N)$ | $O(N)$ | [`SimplifyPath.java`](./Day02_Stack_and_Queue/SimplifyPath.java) |

### Day 03: Advanced Backtracking
| # | Problem Name | LeetCode Link | Topic Tag | Time | Space | Solution Code |
| :-: | :--- | :--- | :--- | :--- | :--- | :--- |
| 18 | N-Queens | [LeetCode #51](https://leetcode.com/problems/n-queens/) | Backtracking | $O(N!)$ | $O(N^2)$ | [`NQueens.java`](./Day03_Advanced_Backtracking/NQueens.java) |
| 19 | Sudoku Solver | [LeetCode #37](https://leetcode.com/problems/sudoku-solver/) | Backtracking | $O(9^{81})$ | $O(1)$ | [`SudokuSolver.java`](./Day03_Advanced_Backtracking/SudokuSolver.java) |
| 20 | Permutations | [LeetCode #46](https://leetcode.com/problems/permutations/) | Backtracking | $O(N \times N!)$ | $O(N)$ | [`Permutations.java`](./Day03_Advanced_Backtracking/Permutations.java) |
| 21 | Permutations II | [LeetCode #47](https://leetcode.com/problems/permutations-ii/) | Backtracking | $O(N \times N!)$ | $O(N)$ | [`PermutationsII.java`](./Day03_Advanced_Backtracking/PermutationsII.java) |
| 22 | Subsets | [LeetCode #78](https://leetcode.com/problems/subsets/) | Backtracking | $O(N \times 2^N)$ | $O(N)$ | [`Subsets.java`](./Day03_Advanced_Backtracking/Subsets.java) |
| 23 | Combination Sum | [LeetCode #39](https://leetcode.com/problems/combination-sum/) | Backtracking | $O(N^{T/M})$ | $O(T/M)$ | [`CombinationSum.java`](./Day03_Advanced_Backtracking/CombinationSum.java) |
| 24 | Word Search | [LeetCode #79](https://leetcode.com/problems/word-search/) | Grid DFS | $O(N \times M \times 3^L)$ | $O(L)$ | [`WordSearch.java`](./Day03_Advanced_Backtracking/WordSearch.java) |
| 25 | Palindrome Partitioning | [LeetCode #131](https://leetcode.com/problems/palindrome-partitioning/) | Backtracking | $O(N \times 2^N)$ | $O(N)$ | [`PalindromePartitioning.java`](./Day03_Advanced_Backtracking/PalindromePartitioning.java) |

---

## 🛠️ Verification & Execution

All Java source files are self-contained executable suites with embedded `main()` assertion methods. To compile and run any problem solution:

```bash
# Example: Compile and run NQueens
javac Day03_Advanced_Backtracking/NQueens.java
java -cp Day03_Advanced_Backtracking NQueens
```

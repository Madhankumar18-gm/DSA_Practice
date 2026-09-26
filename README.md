# 🚀 DSA Practice Repository - Daily Study Log & Problem Checklist

Welcome to the **DSA Practice Repository**. This repository contains a structured collection of Data Structures and Algorithms (DSA) problems solved in Java, organized by daily study topics, date-based LeetCode folders, and mock test tracking.

---

## 📊 Repository Summary

- **Total Problems Solved**: `53 Problems`
- **Total Git Commits**: `470+ Commits`
- **Primary Language**: `Java 17+`
- **Remote Repository**: [GitHub - DSA_Practice](https://github.com/Madhankumar18-gm/DSA_Practice.git)

---

## 📅 Study Progress Tracker & Checklist

- [x] **Day 01 - Core DSA Concepts** (Arrays, Linked Lists, Stacks, Trees, Sliding Window, Intervals, DP) — `7 Problems` \| `56 Commits`
- [x] **Day 02 - Stack & Queue Deep Dive** (Design, Monotonic Stack, Monotonic Deque, Multi-Source BFS) — `10 Problems` \| `80 Commits`
- [x] **Day 03 - Advanced Backtracking** (N-Queens, Sudoku Solver, Permutations, Subsets, Grid DFS) — `8 Problems` \| `72 Commits`
- [x] **Day 04 - Trees & BST Concepts** (Height, Range Bounds, Inversion, Level Order, Reconstruction, Codec, Path Sum) — `10 Problems` \| `90 Commits`
- [x] **Day 05 - Linked List Concepts** (Fast & Slow Pointers, Floyd's Cycle, Dummy Nodes, 3-Pass Interleaving, PriorityQueue Heap) — `9 Problems` \| `81 Commits`
- [x] **Day 06 - Singly Linked List Concepts** (In-place Reversals, Dual Pointer Intersect, Bucket Partitioning, Ring Rotation, K-Group) — `9 Problems` \| `81 Commits`
- [ ] **Day 07 - Graphs & Advanced Graph Algorithms** (TBD)
- [ ] **Day 08 - Dynamic Programming Advanced** (TBD)

---

## 📁 Repository Directory Structure

```text
DSA Practice/
├── README.md                            # Main study log, problem checklist & commit tracker
├── .gitignore                           # Java environment gitignore rules
│
├── Day01_Core_DSA/                      # Topic Folder Day 1 (7 problems)
├── Day02_Stack_and_Queue/               # Topic Folder Day 2 (10 problems)
├── Day03_Advanced_Backtracking/         # Topic Folder Day 3 (8 problems)
├── Day04_Trees_and_BST/                 # Topic Folder Day 4 (10 problems)
├── Day05_Linked_List/                   # Topic Folder Day 5 (9 problems)
├── Day06_Singly_Linked_List/            # Topic Folder Day 6 (9 problems)
│   ├── PalindromeLinkedList.java
│   ├── IntersectionOfTwoLinkedLists.java
│   ├── RemoveDuplicatesFromSortedList.java
│   ├── RemoveDuplicatesFromSortedListII.java
│   ├── PartitionList.java
│   ├── RotateList.java
│   ├── ReverseLinkedListII.java
│   ├── SwapNodesInPairs.java
│   └── ReverseNodesInKGroup.java
│
├── LeetCode/                            # Daily Date Folders for LeetCode Problems
│   ├── 2026-09-22/                      # 2026-09-22 Daily Log (7 problems)
│   ├── 2026-09-23/                      # 2026-09-23 Daily Log (18 problems)
│   ├── 2026-09-24/                      # 2026-09-24 Daily Log (10 problems)
│   ├── 2026-09-25/                      # 2026-09-25 Daily Log (9 problems)
│   └── 2026-09-26/                      # 2026-09-26 Daily Log (9 problems)
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

### Day 04: Trees & BST Concepts
| # | Problem Name | LeetCode Link | Topic Tag | Time | Space | Solution Code |
| :-: | :--- | :--- | :--- | :--- | :--- | :--- |
| 26 | Maximum Depth of Binary Tree | [LeetCode #104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Trees & DFS | $O(N)$ | $O(H)$ | [`MaximumDepthOfBinaryTree.java`](./Day04_Trees_and_BST/MaximumDepthOfBinaryTree.java) |
| 27 | Validate Binary Search Tree | [LeetCode #98](https://leetcode.com/problems/validate-binary-search-tree/) | BST Properties | $O(N)$ | $O(H)$ | [`ValidateBinarySearchTree.java`](./Day04_Trees_and_BST/ValidateBinarySearchTree.java) |
| 28 | Invert Binary Tree | [LeetCode #226](https://leetcode.com/problems/invert-binary-tree/) | Tree Manipulation | $O(N)$ | $O(H)$ | [`InvertBinaryTree.java`](./Day04_Trees_and_BST/InvertBinaryTree.java) |
| 29 | Lowest Common Ancestor of BST | [LeetCode #235](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | BST Traversal | $O(H)$ | $O(1)$ | [`LowestCommonAncestorBST.java`](./Day04_Trees_and_BST/LowestCommonAncestorBST.java) |
| 30 | Binary Tree Level Order Traversal | [LeetCode #102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Queue BFS | $O(N)$ | $O(W)$ | [`BinaryTreeLevelOrderTraversal.java`](./Day04_Trees_and_BST/BinaryTreeLevelOrderTraversal.java) |
| 31 | Kth Smallest Element in a BST | [LeetCode #230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Inorder Traversal | $O(H + k)$ | $O(H)$ | [`KthSmallestElementInBST.java`](./Day04_Trees_and_BST/KthSmallestElementInBST.java) |
| 32 | Construct Tree from Preorder & Inorder | [LeetCode #105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Tree Construction | $O(N)$ | $O(N)$ | [`ConstructBinaryTreeFromPreorderAndInorder.java`](./Day04_Trees_and_BST/ConstructBinaryTreeFromPreorderAndInorder.java) |
| 33 | Serialize & Deserialize Binary Tree | [LeetCode #297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Codec DFS | $O(N)$ | $O(N)$ | [`SerializeAndDeserializeBinaryTree.java`](./Day04_Trees_and_BST/SerializeAndDeserializeBinaryTree.java) |
| 34 | Binary Tree Maximum Path Sum | [LeetCode #124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard DFS Path | $O(N)$ | $O(H)$ | [`BinaryTreeMaximumPathSum.java`](./Day04_Trees_and_BST/BinaryTreeMaximumPathSum.java) |
| 35 | Balanced Binary Tree | [LeetCode #110](https://leetcode.com/problems/balanced-binary-tree/) | Tree Height | $O(N)$ | $O(H)$ | [`BalancedBinaryTree.java`](./Day04_Trees_and_BST/BalancedBinaryTree.java) |

### Day 05: Linked List Concepts
| # | Problem Name | LeetCode Link | Topic Tag | Time | Space | Solution Code |
| :-: | :--- | :--- | :--- | :--- | :--- | :--- |
| 36 | Middle of the Linked List | [LeetCode #876](https://leetcode.com/problems/middle-of-the-linked-list/) | Fast & Slow Pointers | $O(N)$ | $O(1)$ | [`MiddleOfLinkedList.java`](./Day05_Linked_List/MiddleOfLinkedList.java) |
| 37 | Linked List Cycle | [LeetCode #141](https://leetcode.com/problems/linked-list-cycle/) | Floyd's Cycle Detection | $O(N)$ | $O(1)$ | [`LinkedListCycle.java`](./Day05_Linked_List/LinkedListCycle.java) |
| 38 | Linked List Cycle II | [LeetCode #142](https://leetcode.com/problems/linked-list-cycle-ii/) | Cycle Entry Math | $O(N)$ | $O(1)$ | [`LinkedListCycleII.java`](./Day05_Linked_List/LinkedListCycleII.java) |
| 39 | Merge Two Sorted Lists | [LeetCode #21](https://leetcode.com/problems/merge-two-sorted-lists/) | Dummy Node Pointer Splicing | $O(N + M)$ | $O(1)$ | [`MergeTwoSortedLists.java`](./Day05_Linked_List/MergeTwoSortedLists.java) |
| 40 | Remove Nth Node From End of List | [LeetCode #19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/) | Two Pointers Gap | $O(N)$ | $O(1)$ | [`RemoveNthNodeFromEnd.java`](./Day05_Linked_List/RemoveNthNodeFromEnd.java) |
| 41 | Reorder List | [LeetCode #143](https://leetcode.com/problems/reorder-list/) | Mid-Find & Reverse Interleave | $O(N)$ | $O(1)$ | [`ReorderList.java`](./Day05_Linked_List/ReorderList.java) |
| 42 | Copy List with Random Pointer | [LeetCode #138](https://leetcode.com/problems/copy-list-with-random-pointer/) | 3-Pass Interleaving | $O(N)$ | $O(1)$ | [`CopyListWithRandomPointer.java`](./Day05_Linked_List/CopyListWithRandomPointer.java) |
| 43 | Add Two Numbers | [LeetCode #2](https://leetcode.com/problems/add-two-numbers/) | Carry Digit Arithmetic | $O(\max(N, M))$ | $O(\max(N, M))$ | [`AddTwoNumbers.java`](./Day05_Linked_List/AddTwoNumbers.java) |
| 44 | Merge k Sorted Lists | [LeetCode #23](https://leetcode.com/problems/merge-k-sorted-lists/) | PriorityQueue Min-Heap | $O(N \log K)$ | $O(K)$ | [`MergeKSortedLists.java`](./Day05_Linked_List/MergeKSortedLists.java) |

### Day 06: Singly Linked List Concepts
| # | Problem Name | LeetCode Link | Topic Tag | Time | Space | Solution Code |
| :-: | :--- | :--- | :--- | :--- | :--- | :--- |
| 45 | Palindrome Linked List | [LeetCode #234](https://leetcode.com/problems/palindrome-linked-list/) | Mid-Find & Half Reversal | $O(N)$ | $O(1)$ | [`PalindromeLinkedList.java`](./Day06_Singly_Linked_List/PalindromeLinkedList.java) |
| 46 | Intersection of Two Linked Lists | [LeetCode #160](https://leetcode.com/problems/intersection-of-two-linked-lists/) | Dual Pointer Traversal | $O(N + M)$ | $O(1)$ | [`IntersectionOfTwoLinkedLists.java`](./Day06_Singly_Linked_List/IntersectionOfTwoLinkedLists.java) |
| 47 | Remove Duplicates from Sorted List | [LeetCode #83](https://leetcode.com/problems/remove-duplicates-from-sorted-list/) | Single-Pass Deduplication | $O(N)$ | $O(1)$ | [`RemoveDuplicatesFromSortedList.java`](./Day06_Singly_Linked_List/RemoveDuplicatesFromSortedList.java) |
| 48 | Remove Duplicates from Sorted List II | [LeetCode #82](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) | Predecessor Pointer | $O(N)$ | $O(1)$ | [`RemoveDuplicatesFromSortedListII.java`](./Day06_Singly_Linked_List/RemoveDuplicatesFromSortedListII.java) |
| 49 | Partition List | [LeetCode #86](https://leetcode.com/problems/partition-list/) | Dual Dummy Buckets | $O(N)$ | $O(1)$ | [`PartitionList.java`](./Day06_Singly_Linked_List/PartitionList.java) |
| 50 | Rotate List | [LeetCode #61](https://leetcode.com/problems/rotate-list/) | Circular Ring & Break | $O(N)$ | $O(1)$ | [`RotateList.java`](./Day06_Singly_Linked_List/RotateList.java) |
| 51 | Reverse Linked List II | [LeetCode #92](https://leetcode.com/problems/reverse-linked-list-ii/) | One-Pass Subsegment Reversal | $O(N)$ | $O(1)$ | [`ReverseLinkedListII.java`](./Day06_Singly_Linked_List/ReverseLinkedListII.java) |
| 52 | Swap Nodes in Pairs | [LeetCode #24](https://leetcode.com/problems/swap-nodes-in-pairs/) | Iterative Pair Splicing | $O(N)$ | $O(1)$ | [`SwapNodesInPairs.java`](./Day06_Singly_Linked_List/SwapNodesInPairs.java) |
| 53 | Reverse Nodes in k-Group | [LeetCode #25](https://leetcode.com/problems/reverse-nodes-in-k-group/) | K-Group Segment Reversal | $O(N)$ | $O(1)$ | [`ReverseNodesInKGroup.java`](./Day06_Singly_Linked_List/ReverseNodesInKGroup.java) |

---

## 🛠️ Verification & Execution

All Java source files are self-contained executable suites with embedded `main()` assertion methods. To compile and run any problem solution:

```bash
# Example: Compile and run PalindromeLinkedList
javac Day06_Singly_Linked_List/PalindromeLinkedList.java
java -cp Day06_Singly_Linked_List PalindromeLinkedList
```

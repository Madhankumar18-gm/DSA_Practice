# 📅 Daily LeetCode Log - 2026-09-22

This directory contains the 7 LeetCode problems completed on **2026-09-22** covering fundamental Data Structures and Algorithms.

---

## 📝 Problem Summary & Complexity Breakdown

| Problem | LeetCode Link | Topic Tag | Time Complexity | Space Complexity | Solution Code |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Two Sum** | [LeetCode #1](https://leetcode.com/problems/two-sum/) | Arrays & Hashing | $O(N)$ | $O(N)$ | [`TwoSum.java`](./TwoSum.java) |
| **Reverse Linked List** | [LeetCode #206](https://leetcode.com/problems/reverse-linked-list/) | Linked Lists | $O(N)$ | $O(1)$ | [`ReverseLinkedList.java`](./ReverseLinkedList.java) |
| **Valid Parentheses** | [LeetCode #20](https://leetcode.com/problems/valid-parentheses/) | Stack | $O(N)$ | $O(N)$ | [`ValidParentheses.java`](./ValidParentheses.java) |
| **Binary Tree Inorder Traversal** | [LeetCode #94](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Trees & DFS | $O(N)$ | $O(H)$ | [`BinaryTreeInorderTraversal.java`](./BinaryTreeInorderTraversal.java) |
| **Longest Substring Without Repeating** | [LeetCode #3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | Sliding Window | $O(N)$ | $O(\min(N, M))$ | [`LongestSubstring.java`](./LongestSubstring.java) |
| **Merge Intervals** | [LeetCode #56](https://leetcode.com/problems/merge-intervals/) | Sorting & Intervals | $O(N \log N)$ | $O(N)$ | [`MergeIntervals.java`](./MergeIntervals.java) |
| **Coin Change** | [LeetCode #322](https://leetcode.com/problems/coin-change/) | Dynamic Programming | $O(A \times N)$ | $O(A)$ | [`CoinChange.java`](./CoinChange.java) |

---

## 💡 Key Takeaways
- **HashMap Lookup**: Two Sum optimized from $O(N^2)$ to $O(N)$ using target complement mapping.
- **Two Pointers / In-place**: Reversing linked list in $O(1)$ space using iterative pointer swaps.
- **Sliding Window**: Substring tracking using dynamic index window pointers and HashSet.
- **Dynamic Programming**: Coin change 1D bottom-up tabular optimization avoiding exponential subproblems.

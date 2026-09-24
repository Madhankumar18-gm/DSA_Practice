# 📅 Daily LeetCode Log - 2026-09-24

This directory contains the 10 LeetCode problems completed on **2026-09-24** covering Binary Trees & Binary Search Trees (BST).

---

## 📝 Problem Summary & Complexity Breakdown

| Problem | LeetCode Link | Topic Tag | Time Complexity | Space Complexity | Solution Code |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Maximum Depth of Binary Tree** | [LeetCode #104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | Trees & DFS | $O(N)$ | $O(H)$ | [`MaximumDepthOfBinaryTree.java`](./MaximumDepthOfBinaryTree.java) |
| **Validate Binary Search Tree** | [LeetCode #98](https://leetcode.com/problems/validate-binary-search-tree/) | BST Properties | $O(N)$ | $O(H)$ | [`ValidateBinarySearchTree.java`](./ValidateBinarySearchTree.java) |
| **Invert Binary Tree** | [LeetCode #226](https://leetcode.com/problems/invert-binary-tree/) | Tree Manipulation | $O(N)$ | $O(H)$ | [`InvertBinaryTree.java`](./InvertBinaryTree.java) |
| **Lowest Common Ancestor of BST** | [LeetCode #235](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | BST Traversal | $O(H)$ | $O(1)$ | [`LowestCommonAncestorBST.java`](./LowestCommonAncestorBST.java) |
| **Binary Tree Level Order Traversal** | [LeetCode #102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Queue BFS | $O(N)$ | $O(W)$ | [`BinaryTreeLevelOrderTraversal.java`](./BinaryTreeLevelOrderTraversal.java) |
| **Kth Smallest Element in a BST** | [LeetCode #230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Inorder Traversal | $O(H + k)$ | $O(H)$ | [`KthSmallestElementInBST.java`](./KthSmallestElementInBST.java) |
| **Construct Tree from Preorder & Inorder** | [LeetCode #105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Tree Construction | $O(N)$ | $O(N)$ | [`ConstructBinaryTreeFromPreorderAndInorder.java`](./ConstructBinaryTreeFromPreorderAndInorder.java) |
| **Serialize & Deserialize Binary Tree** | [LeetCode #297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Codec DFS | $O(N)$ | $O(N)$ | [`SerializeAndDeserializeBinaryTree.java`](./SerializeAndDeserializeBinaryTree.java) |
| **Binary Tree Maximum Path Sum** | [LeetCode #124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | Hard DFS Path | $O(N)$ | $O(H)$ | [`BinaryTreeMaximumPathSum.java`](./BinaryTreeMaximumPathSum.java) |
| **Balanced Binary Tree** | [LeetCode #110](https://leetcode.com/problems/balanced-binary-tree/) | Tree Height | $O(N)$ | $O(H)$ | [`BalancedBinaryTree.java`](./BalancedBinaryTree.java) |

---

## 💡 Key Takeaways
- **BST Inorder Invariant**: Inorder traversal of a BST produces a strictly ascending sequence ($A_1 < A_2 < \dots < A_N$).
- **Range Boundaries**: Range validation (`min < val < max`) using `Long` bounds prevents integer overflow edge cases.
- **Tree Reconstruction**: Using a HashMap for $O(1)$ index lookup in `inorder` speeds up preorder array partition during tree reconstruction.
- **Post-Order Path Sum**: Calculating maximum non-negative gains from left and right subtrees yields global maximum path sum across root nodes.

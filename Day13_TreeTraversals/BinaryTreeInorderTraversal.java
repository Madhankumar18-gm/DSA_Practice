package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Problem 111: [LeetCode 94] Binary Tree Inorder Traversal
 * O(N) Recursive & Stack-based Iterative Inorder (Left -> Root -> Right) Traversal.
 */
public class BinaryTreeInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> inorderTraversalDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private static void helper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        helper(node.left, result);
        result.add(node.val);
        helper(node.right, result);
    }
    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assert inorderTraversalDFS(root).equals(Arrays.asList(1, 3, 2));
        assert inorderTraversalIterative(root).equals(Arrays.asList(1, 3, 2));
        TreeNode single = new TreeNode(42);
        assert inorderTraversalIterative(single).equals(Arrays.asList(42));
        assert inorderTraversalIterative(null).isEmpty();
    }
}

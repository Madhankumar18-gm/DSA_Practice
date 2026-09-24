/**
 * Problem 35: Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 */
public class BalancedBinaryTree {
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

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // Naive O(N^2) balance check
    public static boolean isBalancedNaive(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(height(root.left) - height(root.right)) > 1) return false;
        return isBalancedNaive(root.left) && isBalancedNaive(root.right);
    }

    public static boolean isBalanced(TreeNode root) {
        return isBalancedNaive(root);
    }
}

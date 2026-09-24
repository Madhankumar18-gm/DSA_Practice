/**
 * Problem 26: Maximum Depth of Binary Tree
 * 
 * Given the root of a binary tree, return its maximum depth.
 */
public class MaximumDepthOfBinaryTree {
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

    // Baseline recursive height helper
    public static int heightHelper(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(heightHelper(node.left), heightHelper(node.right));
    }

    public static int maxDepth(TreeNode root) {
        return heightHelper(root);
    }
}

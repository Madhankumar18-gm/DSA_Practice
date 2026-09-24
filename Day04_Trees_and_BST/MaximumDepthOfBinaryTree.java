import java.util.LinkedList;
import java.util.Queue;

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

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println("Single Node Depth: " + maxDepth(new TreeNode(1)));
        TreeNode skewed = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println("Skewed Tree Depth: " + maxDepth(skewed));
    }
}

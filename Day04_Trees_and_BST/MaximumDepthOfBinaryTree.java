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

    // Optimal Recursive DFS O(N)
    public static int maxDepthDFS(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    public static int maxDepth(TreeNode root) {
        return maxDepthDFS(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Max Depth: " + maxDepth(root));
    }
}

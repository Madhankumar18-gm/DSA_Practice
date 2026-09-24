import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 26: Maximum Depth of Binary Tree
 * 
 * Given the root of a binary tree, return its maximum depth.
 * 
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(H) call stack depth where H is tree height.
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

    /**
     * Calculates maximum depth using DFS.
     * Time: O(N), Space: O(H)
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        System.out.println("=== MaximumDepthOfBinaryTree Execution Suite ===");
        TreeNode tree1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Tree [3, 9, 20, 15, 7] Depth: " + maxDepth(tree1));

        TreeNode tree2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Tree [1, null, 2] Depth:      " + maxDepth(tree2));
        System.out.println("Null Tree Guard Depth:        " + maxDepth(null));
        System.out.println("=== All Tests Completed Successfully ===");
    }
}

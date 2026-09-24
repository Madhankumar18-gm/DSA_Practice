/**
 * Problem 34: Binary Tree Maximum Path Sum
 * 
 * Return the maximum path sum of any non-empty path.
 * 
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(H) recursion stack depth.
 */
public class BinaryTreeMaximumPathSum {
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
     * Calculates maximum path sum using post-order DFS.
     * Time: O(N), Space: O(H)
     */
    public static int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        int[] max = new int[]{Integer.MIN_VALUE};
        maxGain(root, max);
        return max[0];
    }

    private static int maxGain(TreeNode node, int[] max) {
        if (node == null) return 0;
        int left = Math.max(0, maxGain(node.left, max));
        int right = Math.max(0, maxGain(node.right, max));
        max[0] = Math.max(max[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Max Path Sum: " + maxPathSum(root));
    }
}

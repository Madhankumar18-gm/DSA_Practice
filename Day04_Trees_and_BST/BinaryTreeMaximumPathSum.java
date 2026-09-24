/**
 * Problem 34: Binary Tree Maximum Path Sum
 * 
 * Return the maximum path sum of any non-empty path.
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

    // Optimal Post-Order DFS Max Path Sum O(N)
    private static int globalMaxSum = Integer.MIN_VALUE;

    private static int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;
        globalMaxSum = Math.max(globalMaxSum, priceNewPath);

        return node.val + Math.max(leftGain, rightGain);
    }

    public static int maxPathSum(TreeNode root) {
        globalMaxSum = Integer.MIN_VALUE;
        if (root == null) return 0;
        maxGain(root);
        return globalMaxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Max Path Sum: " + maxPathSum(root));
    }
}

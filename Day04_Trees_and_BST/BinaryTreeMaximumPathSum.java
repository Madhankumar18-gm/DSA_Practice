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

    private static int maxSum = Integer.MIN_VALUE;

    private static int gainHelper(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(gainHelper(node.left), 0);
        int rightGain = Math.max(gainHelper(node.right), 0);
        int currentPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currentPathSum);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainHelper(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Max Path Sum: " + maxPathSum(root)); // 6
    }
}

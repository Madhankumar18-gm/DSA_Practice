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

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return checkHeight(root) != -1;
    }

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        System.out.println("Null Root Guard: " + isBalanced(null));
    }
}

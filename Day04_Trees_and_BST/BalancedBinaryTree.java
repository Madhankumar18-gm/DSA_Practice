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

    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        TreeNode unbalanced = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);
        System.out.println("Unbalanced Tree Checked: " + isBalanced(unbalanced)); // false
    }
}

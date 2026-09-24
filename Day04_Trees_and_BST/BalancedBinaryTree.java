/**
 * Problem 35: Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * Time Complexity: O(N) visiting each node once bottom-up.
 * Space Complexity: O(H) recursion stack depth.
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

    /**
     * Checks height balance using bottom-up DFS.
     * Time: O(N), Space: O(H)
     */
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
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Is Balanced? " + isBalanced(root));
    }
}

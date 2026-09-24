/**
 * Problem 27: Validate Binary Search Tree
 * 
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 */
public class ValidateBinarySearchTree {
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

    // Optimal Range Validation using Long bounds O(N)
    private static boolean validateRange(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validateRange(node.left, min, node.val) && validateRange(node.right, node.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return validateRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Is Valid BST? " + isValidBST(root));
    }
}

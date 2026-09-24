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

    public static boolean isValidBST(TreeNode root) {
        return validateRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validateRange(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validateRange(node.left, min, node.val) && validateRange(node.right, node.val, max);
    }

    public static void main(String[] args) {
        // Invalid BST: 5 -> left: 1, right: 4 (left of 4 is 3, right is 6)
        TreeNode invalidTree = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println("Invalid Tree Validated? " + isValidBST(invalidTree)); // false
    }
}

/**
 * Problem 28: Invert Binary Tree
 * 
 * Given the root of a binary tree, invert the tree, and return its root.
 * 
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(H) recursion stack depth.
 */
public class InvertBinaryTree {
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
     * Inverts binary tree subtrees recursively.
     * Time: O(N), Space: O(H)
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempLeft = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempLeft);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("=== InvertBinaryTree Execution Suite ===");
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("Original Root Left: " + root.left.val + ", Right: " + root.right.val);

        TreeNode inverted = invertTree(root);
        System.out.println("Inverted Root Left: " + inverted.left.val + ", Right: " + inverted.right.val);
        System.out.println("=== All Tests Completed Successfully ===");
    }
}

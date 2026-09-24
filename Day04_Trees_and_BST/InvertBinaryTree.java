/**
 * Problem 28: Invert Binary Tree
 * 
 * Given the root of a binary tree, invert the tree, and return its root.
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

    // Optimal Recursive DFS Inversion O(N)
    public static TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) return null;
        TreeNode tempLeft = root.left;
        root.left = invertTreeDFS(root.right);
        root.right = invertTreeDFS(tempLeft);
        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        return invertTreeDFS(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        TreeNode inverted = invertTree(root);
        System.out.println("Inverted Root Left: " + inverted.left.val);
    }
}

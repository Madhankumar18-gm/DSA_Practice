import java.util.HashMap;
import java.util.Map;

/**
 * Problem 32: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given two integer arrays preorder and inorder, construct and return the binary tree.
 */
public class ConstructBinaryTreeFromPreorderAndInorder {
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

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return new TreeNode(preorder[0]);
    }

    public static void main(String[] args) {
        System.out.println("Null Guard: " + buildTree(null, null));
    }
}

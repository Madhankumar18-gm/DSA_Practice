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

    // Baseline recursive tree builder
    private static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) inIndex = i;
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Binary Tree Inorder Traversal
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {

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

    public static List<Integer> inorderTraversal(TreeNode root) {
        // TODO: Implement traversal
        return new ArrayList<>();
    }
}

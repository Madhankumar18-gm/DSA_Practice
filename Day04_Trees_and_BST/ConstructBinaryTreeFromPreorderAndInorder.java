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

    private static int preIndex = 0;
    private static Map<Integer, Integer> inMap = new HashMap<>();

    private static TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, left, inMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inMap.get(rootVal) + 1, right);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) return null;
        preIndex = 0;
        inMap.clear();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    public static void printPreorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.print("Reconstructed Preorder: ");
        printPreorder(root);
        System.out.println();
    }
}

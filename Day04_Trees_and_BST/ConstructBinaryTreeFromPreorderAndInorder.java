import java.util.HashMap;
import java.util.Map;

/**
 * Problem 32: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given two integer arrays preorder and inorder, construct and return the binary tree.
 * 
 * Time Complexity: O(N) constructing tree using HashMap index lookup.
 * Space Complexity: O(N) storing HashMap and recursion call stack.
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

    /**
     * Rebuilds binary tree from preorder and inorder arrays.
     * Time: O(N), Space: O(N)
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        preIndex = 0;
        inMap.clear();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private static TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = arrayToTree(preorder, left, inMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inMap.get(rootVal) + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println("Built Root: " + root.val);
    }
}

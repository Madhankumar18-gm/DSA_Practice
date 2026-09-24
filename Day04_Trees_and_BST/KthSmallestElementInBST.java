import java.util.Stack;

/**
 * Problem 31: Kth Smallest Element in a BST
 * 
 * Given the root of a binary search tree, and an integer k, return the kth smallest value.
 */
public class KthSmallestElementInBST {
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

    private static int count = 0;
    private static int result = -1;

    private static void inorderDFS(TreeNode root, int k) {
        if (root == null) return;
        inorderDFS(root.left, k);
        count++;
        if (count == k) {
            result = root.val;
            return;
        }
        inorderDFS(root.right, k);
    }

    public static int kthSmallestRecursive(TreeNode root, int k) {
        count = 0;
        result = -1;
        inorderDFS(root, k);
        return result;
    }

    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallestRecursive(root, k);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println("1st Smallest (DFS): " + kthSmallest(root, 1));
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 31: Kth Smallest Element in a BST
 * 
 * Given the root of a binary search tree, and an integer k, return the kth smallest value of all the values in the tree.
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

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static int kthSmallestList(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    public static int kthSmallest(TreeNode root, int k) {
        return kthSmallestList(root, k);
    }
}

import java.util.LinkedList;
import java.util.Queue;

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

    // Iterative BFS Queue tree inversion
    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
        return root;
    }

    public static TreeNode invertTree(TreeNode root) {
        return invertTreeBFS(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2), new TreeNode(7));
        TreeNode inverted = invertTree(root);
        System.out.println("Inverted Root Left (BFS): " + inverted.left.val);
    }
}

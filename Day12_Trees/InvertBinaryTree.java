package Day12_Trees;

import java.util.LinkedList;
import java.util.Queue;

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
    public static TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
    public static TreeNode invertTreeDFS(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTreeDFS(root.left);
        TreeNode right = invertTreeDFS(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode inverted = invertTreeBFS(root);
        assert inverted.left.val == 7;
        assert inverted.right.val == 2;
        TreeNode root2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode inv2 = invertTreeDFS(root2);
        assert inv2.left.val == 3 && inv2.right.val == 1;
    }
}

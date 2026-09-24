import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 26: Maximum Depth of Binary Tree
 * 
 * Given the root of a binary tree, return its maximum depth.
 */
public class MaximumDepthOfBinaryTree {
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

    // Iterative BFS Queue level-order height calculation
    public static int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return depth;
    }

    public static int maxDepth(TreeNode root) {
        return maxDepthBFS(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Max Depth (BFS): " + maxDepth(root));
    }
}

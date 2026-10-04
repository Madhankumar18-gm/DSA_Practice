package Day12_Trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 105: [LeetCode 101] Symmetric Tree
 * O(N) Mirror recursive and BFS queue mirror evaluation.
 */
public class SymmetricTree {
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
    public static boolean isSymmetricBFS(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
    public static boolean isSymmetricDFS(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null || t1.val != t2.val) return false;
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(3), new TreeNode(4)), 
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        assert isSymmetricBFS(root);
        assert isSymmetricDFS(root);
        TreeNode asymmetric = new TreeNode(1, 
            new TreeNode(2, null, new TreeNode(3)), 
            new TreeNode(2, null, new TreeNode(3)));
        assert !isSymmetricDFS(asymmetric);
        assert isSymmetricDFS(null);
    }
}

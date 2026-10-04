package Day12_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
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
    public static boolean isSameTreeBFS(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            queue.add(n1.left);
            queue.add(n2.left);
            queue.add(n1.right);
            queue.add(n2.right);
        }
        return true;
    }
    public static boolean isSameTreeDFS(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTreeDFS(p.left, q.left) && isSameTreeDFS(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assert isSameTreeBFS(t1, t2);
        assert isSameTreeDFS(t1, t2);
        TreeNode t3 = new TreeNode(1, new TreeNode(2), null);
        TreeNode t4 = new TreeNode(1, null, new TreeNode(2));
        assert !isSameTreeDFS(t3, t4);
        assert isSameTreeDFS(null, null);
        assert !isSameTreeDFS(t1, null);
    }
}

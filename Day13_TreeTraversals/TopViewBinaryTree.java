package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {
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
    private static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static List<Integer> topViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if (!map.containsKey(p.hd)) {
                map.put(p.hd, p.node.val);
            }
            if (p.node.left != null) queue.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) queue.add(new Pair(p.node.right, p.hd + 1));
        }
        for (int val : map.values()) {
            result.add(val);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))), 
            new TreeNode(3));
        assert topViewBFS(root).equals(Arrays.asList(2, 1, 3, 6));
    }
}

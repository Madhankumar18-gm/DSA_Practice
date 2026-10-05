package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBinaryTree {
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
    public static List<Integer> bottomViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            map.put(p.hd, p.node.val);
            if (p.node.left != null) queue.add(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null) queue.add(new Pair(p.node.right, p.hd + 1));
        }
        for (int val : map.values()) {
            result.add(val);
        }
        return result;
    }
    public static List<Integer> bottomViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, int[]> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        for (int[] pair : map.values()) {
            result.add(pair[0]);
        }
        return result;
    }
    private static void dfs(TreeNode node, int hd, int depth, Map<Integer, int[]> map) {
        if (node == null) return;
        if (!map.containsKey(hd) || depth >= map.get(hd)[1]) {
            map.put(hd, new int[]{node.val, depth});
        }
        dfs(node.left, hd - 1, depth + 1, map);
        dfs(node.right, hd + 1, depth + 1, map);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20, 
            new TreeNode(8, new TreeNode(5), new TreeNode(3, new TreeNode(10), new TreeNode(14))), 
            new TreeNode(22, null, new TreeNode(25)));
        assert bottomViewBFS(root).equals(Arrays.asList(5, 10, 3, 14, 25));
    }
}

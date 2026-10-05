package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VerticalOrderTraversal {
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
    public static List<List<Integer>> verticalTraversalDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        for (Map<Integer, List<Integer>> cols : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (List<Integer> nodes : cols.values()) {
                Collections.sort(nodes);
                colList.addAll(nodes);
            }
            result.add(colList);
        }
        return result;
    }
    private static void dfs(TreeNode node, int row, int col, Map<Integer, Map<Integer, List<Integer>>> map) {
        if (node == null) return;
        map.putIfAbsent(col, new TreeMap<>());
        map.get(col).putIfAbsent(row, new ArrayList<>());
        map.get(col).get(row).add(node.val);
        dfs(node.left, row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(9), Arrays.asList(3, 15), Arrays.asList(20), Arrays.asList(7));
        assert verticalTraversalDFS(root).equals(expected);
        TreeNode single = new TreeNode(1);
        assert verticalTraversalDFS(single).equals(Arrays.asList(Arrays.asList(1)));
    }
}

package Day12_Trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
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
    public static List<String> binaryTreePathsNaive(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) dfsNaive(root, "", result);
        return result;
    }
    private static void dfsNaive(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }
        if (node.left != null) dfsNaive(node.left, path + node.val + "->", result);
        if (node.right != null) dfsNaive(node.right, path + node.val + "->", result);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<String> res = binaryTreePathsNaive(root);
        assert res.contains("1->2->5") && res.contains("1->3");
    }
}

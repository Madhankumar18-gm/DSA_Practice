package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
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
    public static List<Integer> preorderTraversalDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private static void helper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
    }
}

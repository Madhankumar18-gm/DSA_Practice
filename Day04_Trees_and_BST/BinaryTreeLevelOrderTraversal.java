import java.util.ArrayList;
import java.util.List;

/**
 * Problem 30: Binary Tree Level Order Traversal
 * 
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 */
public class BinaryTreeLevelOrderTraversal {
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

    // Recursive DFS level-indexed alternative solution
    private static void dfsLevel(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        dfsLevel(node.left, level + 1, result);
        dfsLevel(node.right, level + 1, result);
    }

    public static List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsLevel(root, 0, result);
        return result;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderDFS(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println("Level Order (DFS): " + levelOrder(root));
    }
}

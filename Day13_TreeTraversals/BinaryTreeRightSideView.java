package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem 116: [LeetCode 199] Binary Tree Right Side View
 * O(N) BFS last level element & DFS Root->Right->Left depth matching algorithm.
 */
public class BinaryTreeRightSideView {
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
    public static List<Integer> rightSideViewBFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (i == size - 1) result.add(current.val);
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
        return result;
    }
    public static List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    private static void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) return;
        if (depth == result.size()) result.add(node.val);
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, null, new TreeNode(5)), 
            new TreeNode(3, null, new TreeNode(4)));
        assert rightSideViewBFS(root).equals(Arrays.asList(1, 3, 4));
        assert rightSideViewDFS(root).equals(Arrays.asList(1, 3, 4));
        TreeNode leftDeep = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
        assert rightSideViewDFS(leftDeep).equals(Arrays.asList(1, 3, 4));
        assert rightSideViewDFS(null).isEmpty();
        System.out.println("Execution completed successfully for BinaryTreeRightSideView.");
    }
}

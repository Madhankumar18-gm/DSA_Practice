package Day12_Trees;

import java.util.LinkedList;
import java.util.Queue;

public class PathSum {
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
    public static boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> sumQueue = new LinkedList<>();
        nodeQueue.add(root);
        sumQueue.add(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int currentSum = sumQueue.poll();
            if (node.left == null && node.right == null && currentSum == targetSum) return true;
            if (node.left != null) {
                nodeQueue.add(node.left);
                sumQueue.add(currentSum + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                sumQueue.add(currentSum + node.right.val);
            }
        }
        return false;
    }
    public static boolean hasPathSumDFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return targetSum == root.val;
        return hasPathSumDFS(root.left, targetSum - root.val) || hasPathSumDFS(root.right, targetSum - root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, 
            new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
            new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
        assert hasPathSumBFS(root, 22);
        assert hasPathSumDFS(root, 22);
    }
}

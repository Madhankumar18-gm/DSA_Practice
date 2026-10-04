package Day12_Trees;

public class CountCompleteTreeNodes {
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
    public static int countNodesLinear(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodesLinear(root.left) + countNodesLinear(root.right);
    }
}

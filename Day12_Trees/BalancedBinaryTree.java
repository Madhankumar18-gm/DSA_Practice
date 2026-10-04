package Day12_Trees;

public class BalancedBinaryTree {
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
    public static boolean isBalancedNaive(TreeNode root) {
        if (root == null) return true;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        if (Math.abs(leftH - rightH) > 1) return false;
        return isBalancedNaive(root.left) && isBalancedNaive(root.right);
    }
    private static int getHeight(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}

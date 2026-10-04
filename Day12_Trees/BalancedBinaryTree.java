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
    public static boolean isBalancedOptimal(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int left = checkHeight(node.left);
        if (left == -1) return -1;
        int right = checkHeight(node.right);
        if (right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        assert isBalancedNaive(root);
    }
}

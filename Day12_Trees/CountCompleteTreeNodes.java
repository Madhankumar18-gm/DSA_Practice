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
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), new TreeNode(5)), 
            new TreeNode(3, new TreeNode(6), null));
        assert countNodesLinear(root) == 6;
    }
}

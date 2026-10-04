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
    public static int countNodesOptimal(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;
        }
        return 1 + countNodesOptimal(root.left) + countNodesOptimal(root.right);
    }
    private static int getLeftHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }
    private static int getRightHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.right;
        }
        return h;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, 
            new TreeNode(2, new TreeNode(4), new TreeNode(5)), 
            new TreeNode(3, new TreeNode(6), null));
        assert countNodesLinear(root) == 6;
        assert countNodesOptimal(root) == 6;
    }
}

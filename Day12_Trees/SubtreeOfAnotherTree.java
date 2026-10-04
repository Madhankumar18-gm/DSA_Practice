package Day12_Trees;

public class SubtreeOfAnotherTree {
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
    public static boolean isSubtreeString(TreeNode root, TreeNode subRoot) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        serialize(root, sb1);
        serialize(subRoot, sb2);
        return sb1.toString().contains(sb2.toString());
    }
    private static void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(",#");
            return;
        }
        sb.append(",").append(node.val);
        serialize(node.left, sb);
        serialize(node.right, sb);
    }
}

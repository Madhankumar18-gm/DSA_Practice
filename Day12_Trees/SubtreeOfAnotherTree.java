package Day12_Trees;

/**
 * Problem 106: [LeetCode 572] Subtree of Another Tree
 * O(M*N) Recursive tree matching & string serialization comparison.
 */
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
    public static boolean isSubtreeDFS(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSame(root, subRoot)) return true;
        return isSubtreeDFS(root.left, subRoot) || isSubtreeDFS(root.right, subRoot);
    }
    private static boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSame(p.left, q.left) && isSame(p.right, q.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode sub = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        assert isSubtreeString(root, sub);
        assert isSubtreeDFS(root, sub);
        TreeNode notSub = new TreeNode(4, new TreeNode(1), new TreeNode(3));
        assert !isSubtreeDFS(root, notSub);
        assert isSubtreeDFS(root, null);
        assert !isSubtreeDFS(null, sub);
    }
}

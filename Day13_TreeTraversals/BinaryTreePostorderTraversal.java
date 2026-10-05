package Day13_TreeTraversals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
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
    public static List<Integer> postorderTraversalDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }
    private static void helper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);
    }
    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.addFirst(current.val);
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assert postorderTraversalDFS(root).equals(Arrays.asList(3, 2, 1));
        assert postorderTraversalIterative(root).equals(Arrays.asList(3, 2, 1));
        TreeNode single = new TreeNode(7);
        assert postorderTraversalIterative(single).equals(Arrays.asList(7));
        assert postorderTraversalIterative(null).isEmpty();
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem 4: Binary Tree Inorder Traversal
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {

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

    public static void helperRecursive(TreeNode root, List<Integer> result) {
        if (root == null) return;
        helperRecursive(root.left, result);
        result.add(root.val);
        helperRecursive(root.right, result);
    }

    // Iterative Inorder Traversal using Stack
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        return inorderIterative(root);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Inorder Result: " + inorderTraversal(root));
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Problem 4: Binary Tree Inorder Traversal
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Time Complexity: O(N) visiting each node once.
 * Space Complexity: O(H) where H is tree height for stack storage.
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

    /**
     * Traverses binary tree in-order (Left, Root, Right).
     * Time: O(N), Space: O(H)
     */
    public static List<Integer> inorderIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

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
        System.out.println("=== BinaryTreeInorderTraversal Execution Suite ===");
        
        TreeNode tree1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println("Tree [1, null, 2, 3]: " + inorderTraversal(tree1));

        TreeNode tree2 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        System.out.println("BST [4, 2, 5, 1, 3]: " + inorderTraversal(tree2));

        System.out.println("Null Tree Test:     " + inorderTraversal(null));
        System.out.println("Single Node Test:   " + inorderTraversal(new TreeNode(42)));
        System.out.println("=== All Tests Completed Successfully ===");
    }
}

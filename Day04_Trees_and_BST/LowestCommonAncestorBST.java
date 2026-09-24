/**
 * Problem 29: Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * 
 * Time Complexity: O(H) where H is tree height (O(log N) for balanced BST).
 * Space Complexity: O(1) for iterative traversal.
 */
public class LowestCommonAncestorBST {
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
     * Finds LCA in BST using value bounds.
     * Time: O(H), Space: O(1)
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("=== LowestCommonAncestorBST Execution Suite ===");
        TreeNode n2 = new TreeNode(2, new TreeNode(0), new TreeNode(4));
        TreeNode n8 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode root = new TreeNode(6, n2, n8);

        System.out.println("LCA of 2 and 8 in BST [6,2,8]: " + lowestCommonAncestor(root, n2, n8).val);
        System.out.println("LCA of 2 and 4 in BST [6,2,8]: " + lowestCommonAncestor(root, n2, n2.right).val);
        System.out.println("=== All Tests Completed Successfully ===");
    }
}

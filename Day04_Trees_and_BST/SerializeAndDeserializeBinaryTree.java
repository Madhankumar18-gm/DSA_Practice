import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 33: Serialize and Deserialize Binary Tree
 * 
 * Design an algorithm to serialize and deserialize a binary tree.
 */
public class SerializeAndDeserializeBinaryTree {
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

    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "null,";
            return root.val + "," + serialize(root.left) + serialize(root.right);
        }

        public TreeNode deserialize(String data) {
            return null;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);
    }
}

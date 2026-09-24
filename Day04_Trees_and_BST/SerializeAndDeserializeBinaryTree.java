import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem 33: Serialize and Deserialize Binary Tree
 * 
 * Design an algorithm to serialize and deserialize a binary tree.
 * 
 * Time Complexity: O(N) for both serialize and deserialize.
 * Space Complexity: O(N) string storage and queue buffer.
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

    /**
     * Codec helper class for tree string conversion.
     * Time: O(N), Space: O(N)
     */
    public static class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder sb = new StringBuilder();
            buildString(root, sb);
            return sb.toString();
        }

        private void buildString(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                buildString(node.left, sb);
                buildString(node.right, sb);
            }
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
            return buildTree(nodes);
        }

        private TreeNode buildTree(Queue<String> nodes) {
            if (nodes.isEmpty()) return null;
            String val = nodes.poll();
            if (val == null || val.equals("null")) return null;
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        String s = codec.serialize(root);
        TreeNode d = codec.deserialize(s);
        System.out.println("Reconstructed Root Val: " + d.val);
    }
}

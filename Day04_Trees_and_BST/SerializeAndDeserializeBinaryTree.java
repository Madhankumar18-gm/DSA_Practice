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
        TreeNode single = new TreeNode(42);
        String s = codec.serialize(single);
        TreeNode d = codec.deserialize(s);
        System.out.println("Single Node Reconstructed: " + d.val);
    }
}

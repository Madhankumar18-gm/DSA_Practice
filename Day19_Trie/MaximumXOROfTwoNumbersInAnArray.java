package Day19_Trie;

public class MaximumXOROfTwoNumbersInAnArray {

    public static class BinaryTrieNode {
        public BinaryTrieNode[] children = new BinaryTrieNode[2];
    }

    public static void insert(BinaryTrieNode root, int num) {
        BinaryTrieNode curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new BinaryTrieNode();
            }
            curr = curr.children[bit];
        }
    }

    public static void main(String[] args) {
        BinaryTrieNode root = new BinaryTrieNode();
        insert(root, 5);
        assert root.children[0] != null : "Bit 31 of 5 is 0";
    }
}

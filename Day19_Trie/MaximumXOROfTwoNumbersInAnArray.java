package Day19_Trie;

public class MaximumXOROfTwoNumbersInAnArray {

    public static class BinaryTrieNode {
        public BinaryTrieNode[] children = new BinaryTrieNode[2]; // 0 and 1
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
}

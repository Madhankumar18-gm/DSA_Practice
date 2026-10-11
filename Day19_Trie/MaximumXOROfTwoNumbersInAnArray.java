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

    public static int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        BinaryTrieNode root = new BinaryTrieNode();
        for (int num : nums) {
            insert(root, num);
        }

        int maxXor = 0;
        for (int num : nums) {
            BinaryTrieNode curr = root;
            int currentXor = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit;
                if (curr.children[oppositeBit] != null) {
                    currentXor |= (1 << i);
                    curr = curr.children[oppositeBit];
                } else {
                    curr = curr.children[bit];
                }
            }
            maxXor = Math.max(maxXor, currentXor);
        }

        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 10, 5, 25, 2, 8};
        assert findMaximumXOR(nums1) == 28 : "Test 1 Failed: 5 ^ 25 = 28";

        int[] nums2 = {14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70};
        assert findMaximumXOR(nums2) == 127 : "Test 2 Failed";
    }
}

package Day14_GraphAndGreedy;

public class JumpGame {
    public static boolean canJumpNaive(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        return canJumpFrom(0, nums);
    }
    private static boolean canJumpFrom(int position, int[] nums) {
        if (position >= nums.length - 1) return true;
        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPos = position + 1; nextPos <= furthestJump; nextPos++) {
            if (canJumpFrom(nextPos, nums)) return true;
        }
        return false;
    }
    public static boolean canJumpGreedy(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }
    public static void main(String[] args) {
        assert canJumpNaive(new int[]{2, 3, 1, 1, 4});
        assert canJumpGreedy(new int[]{2, 3, 1, 1, 4});
        assert !canJumpGreedy(new int[]{3, 2, 1, 0, 4});
        assert canJumpGreedy(new int[]{0});
        assert !canJumpGreedy(null);
    }
}

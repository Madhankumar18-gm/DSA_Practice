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
    public static void main(String[] args) {
        assert canJumpNaive(new int[]{2, 3, 1, 1, 4});
    }
}

package Day18_MockTest_Heaps;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public static int furthestBuildingMinHeap(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length <= 1) return 0;
        // Min-heap to store the largest climb jumps where ladders will be used
        PriorityQueue<Integer> ladderAllocations = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                ladderAllocations.offer(diff);
                if (ladderAllocations.size() > ladders) {
                    bricks -= ladderAllocations.poll();
                    if (bricks < 0) {
                        return i;
                    }
                }
            }
        }
        return heights.length - 1;
    }
}

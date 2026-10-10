package Day18_MockTest_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    public static int furthestBuildingMinHeap(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length <= 1) return 0;
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

    public static int furthestBuildingMaxHeap(int[] heights, int bricks, int ladders) {
        if (heights == null || heights.length <= 1) return 0;
        PriorityQueue<Integer> brickJumps = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff > 0) {
                bricks -= diff;
                brickJumps.offer(diff);

                if (bricks < 0) {
                    if (ladders > 0) {
                        bricks += brickJumps.poll();
                        ladders--;
                    } else {
                        return i;
                    }
                }
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        int[] h1 = {4, 2, 7, 6, 9, 14, 12};
        assert furthestBuildingMinHeap(h1, 5, 1) == 4 : "Test 1 Failed";

        int[] h2 = {4, 12, 2, 7, 3, 18, 20, 3, 19};
        assert furthestBuildingMinHeap(h2, 10, 2) == 7 : "Test 2 Failed";
        assert furthestBuildingMaxHeap(h2, 10, 2) == 7 : "Max Heap Test 2 Failed";

        int[] h3 = {14, 3, 19, 3};
        assert furthestBuildingMinHeap(h3, 17, 0) == 3 : "Test 3 Full Reach";
    }
}

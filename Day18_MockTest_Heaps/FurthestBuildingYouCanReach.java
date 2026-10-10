package Day18_MockTest_Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 1642: Furthest Building You Can Reach
 * 
 * Problem:
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * You start your journey from building 0 and move to the next building:
 * - If next building <= current, you do not need ladders or bricks.
 * - If next building > current, you can either use 1 ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use your resources optimally.
 * 
 * Complexity:
 * - Min-Heap of size L (Ladders): O(N log L) time, O(L) space.
 * - Max-Heap of Bricks: O(N log N) time, O(N) space.
 */
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

        assert furthestBuildingMinHeap(new int[]{5, 5, 5, 5}, 0, 0) == 3 : "Flat terrain";
        assert furthestBuildingMinHeap(new int[]{1, 10}, 0, 0) == 0 : "No resources";
        assert furthestBuildingMinHeap(new int[]{10}, 0, 0) == 0 : "Single building";
    }
}

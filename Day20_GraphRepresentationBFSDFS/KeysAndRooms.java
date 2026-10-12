package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {

    public static boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return true;

        boolean[] visited = new boolean[rooms.size()];
        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private static void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        visited[room] = true;
        for (int key : rooms.get(room)) {
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }

    public static boolean canVisitAllRoomsBFS(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return true;

        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[0] = true;
        queue.offer(0);
        int visitedCount = 1;

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    visitedCount++;
                    queue.offer(key);
                }
            }
        }

        return visitedCount == rooms.size();
    }

    public static void main(String[] args) {
        List<List<Integer>> r1 = Arrays.asList(
            Collections.singletonList(1),
            Collections.singletonList(2),
            Collections.singletonList(3),
            Collections.emptyList()
        );
        assert canVisitAllRoomsDFS(r1) : "Test 1 Failed";
        assert canVisitAllRoomsBFS(r1) : "BFS Test 1 Failed";

        List<List<Integer>> r2 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 0, 1),
            Collections.singletonList(2),
            Collections.singletonList(0)
        );
        assert !canVisitAllRoomsDFS(r2) : "Test 2 Failed";
        assert !canVisitAllRoomsBFS(r2) : "BFS Test 2 Failed";

        // Multi duplicate keys: room 0 has multiple keys to room 1
        List<List<Integer>> dup = Arrays.asList(
            Arrays.asList(1, 1, 1),
            Collections.emptyList()
        );
        assert canVisitAllRoomsBFS(dup) : "Duplicate keys visit ok";
    }
}

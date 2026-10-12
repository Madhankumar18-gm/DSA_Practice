package Day20_GraphRepresentationBFSDFS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    public static void main(String[] args) {
        List<List<Integer>> r1 = Arrays.asList(
            Collections.singletonList(1),
            Collections.singletonList(2),
            Collections.singletonList(3),
            Collections.emptyList()
        );
        assert canVisitAllRoomsDFS(r1) : "Test 1 Failed";

        List<List<Integer>> r2 = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(3, 0, 1),
            Collections.singletonList(2),
            Collections.singletonList(0)
        );
        assert !canVisitAllRoomsDFS(r2) : "Test 2 Failed";
    }
}

package Day14_GraphAndGreedy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            count++;
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        return count == numCourses;
    }
    public static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);
        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, adj, state)) return false;
        }
        return true;
    }
    private static boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;
        state[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (hasCycle(neighbor, adj, state)) return true;
        }
        state[node] = 2;
        return false;
    }
    public static void main(String[] args) {
        assert canFinishBFS(2, new int[][]{{1, 0}});
    }
}

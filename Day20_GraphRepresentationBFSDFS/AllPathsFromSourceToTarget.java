package Day20_GraphRepresentationBFSDFS;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        if (graph == null || graph.length == 0) return paths;

        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        dfs(0, graph.length - 1, graph, currentPath, paths);
        return paths;
    }

    private static void dfs(int curr, int target, int[][] graph, List<Integer> currentPath, List<List<Integer>> paths) {
        if (curr == target) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        for (int next : graph[curr]) {
            currentPath.add(next);
            dfs(next, target, graph, currentPath, paths);
            currentPath.remove(currentPath.size() - 1); // Backtrack
        }
    }
}
